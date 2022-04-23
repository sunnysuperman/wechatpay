package com.sunnysuperman.wechatpay;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.auth.Verifier;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.exception.ParseException;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.exception.ValidationException;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.notification.Notification;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.notification.NotificationHandler;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.notification.NotificationRequest;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.util.CertSerializeUtil;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.util.PemUtil;
import com.sunnysuperman.wechatpay.data.MakeH5PayUrlResponse;
import com.sunnysuperman.wechatpay.data.MakeNativePayUrlResponse;
import com.sunnysuperman.wechatpay.data.MakePayUrlRequest;
import com.sunnysuperman.wechatpay.data.PayNotification;
import com.sunnysuperman.wechatpay.data.RefundRequest;
import com.sunnysuperman.wechatpay.data.RefundResponse;

public class WechatPayApiV3 {
    private static final Logger LOG = LoggerFactory.getLogger(WechatPayApiV3.class);

    private String merchantId;
    private String merchantSerialNo;
    private PrivateKey merchantPrivateKey;
    private String apiV3Key;

    public WechatPayApiV3(String merchantId, String merchantSerialNo, String merchantPrivateKey, String apiV3Key) {
        super();
        this.merchantId = merchantId;
        this.merchantSerialNo = merchantSerialNo;
        this.merchantPrivateKey = PemUtil.loadPrivateKey(merchantPrivateKey);
        this.apiV3Key = apiV3Key;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantSerialNo() {
        return merchantSerialNo;
    }

    public PrivateKey getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public String getApiV3Key() {
        return apiV3Key;
    }

    private CloseableHttpClient getClient() {
        WechatPayHttpClientBuilder httpClientBuilder = WechatPayHttpClientBuilder.create()
                .withMerchant(merchantId, merchantSerialNo, merchantPrivateKey).withValidator(response -> true);
        CloseableHttpClient httpClient = httpClientBuilder.build();
        return httpClient;
    }

    private void error(Throwable t) {
        LOG.error(null, t);
    }

    private void close(CloseableHttpClient client) {
        try {
            client.close();
        } catch (Throwable e) {
            error(e);
        }
    }

    private <T> T postJSON(String url, Object request, Class<T> responseClass) throws WechatPayException {
        CloseableHttpClient client = getClient();
        try {
            String requestAsString = JSONUtil.toJSONString(request);
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setEntity(new StringEntity(requestAsString, StandardCharsets.UTF_8));
            CloseableHttpResponse response = client.execute(httpPost);
            wrapResponse(response);
            String responseAsString = EntityUtils.toString(response.getEntity());
            if (LOG.isInfoEnabled()) {
                LOG.info("[WechatPayApiV3] {},response:\n{}", url, responseAsString);
            }
            return Bean.fromJson(responseAsString, responseClass.newInstance());
        } catch (WechatPayException ex) {
            throw ex;
        } catch (Exception ex) {
            error(ex);
            throw newDefaultException();
        } finally {
            close(client);
        }
    }

    private void wrapResponse(CloseableHttpResponse response) throws WechatPayException {
        Map<String, Object> responseAsMap = null;
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == SC_OK) {
                return;
            }
            String responseAsString = EntityUtils.toString(response.getEntity());
            responseAsMap = JSONUtil.parseJSONObject(responseAsString);
        } catch (Exception ex) {
            error(ex);
        }
        if (responseAsMap == null) {
            throw newDefaultException();
        }
        throw new WechatPayException(responseAsMap.get("code").toString(), responseAsMap.get("message").toString());
    }

    private WechatPayException newDefaultException() {
        return new WechatPayException("NETWORK", "网络错误");
    }

    private <T> T get(String url, Class<T> responseClass) throws WechatPayException {
        CloseableHttpClient client = getClient();
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(ACCEPT, APPLICATION_JSON.toString());
            CloseableHttpResponse response = client.execute(httpGet);
            wrapResponse(response);
            String responseAsString = EntityUtils.toString(response.getEntity());
            return Bean.fromJson(responseAsString, responseClass.newInstance());
        } catch (WechatPayException ex) {
            throw ex;
        } catch (Exception ex) {
            error(ex);
            throw newDefaultException();
        } finally {
            close(client);
        }
    }

    private Map<BigInteger, X509Certificate> downloadCert() throws WechatPayException {
        CloseableHttpClient client = getClient();
        try {
            HttpGet httpGet = new HttpGet("https://api.mch.weixin.qq.com/v3/certificates");
            httpGet.addHeader(ACCEPT, APPLICATION_JSON.toString());
            CloseableHttpResponse response = client.execute(httpGet);
            wrapResponse(response);
            String body = EntityUtils.toString(response.getEntity());
            return CertSerializeUtil.deserializeToCerts(apiV3Key.getBytes(StandardCharsets.UTF_8), body);
        } catch (WechatPayException ex) {
            throw ex;
        } catch (Exception ex) {
            error(ex);
            throw newDefaultException();
        } finally {
            close(client);
        }
    }

    private class DefaultVerifier implements Verifier {
        @Override
        public boolean verify(String serialNumber, byte[] message, String signature) {
            if (serialNumber.isEmpty() || message.length == 0 || signature.isEmpty()) {
                throw new IllegalArgumentException("serialNumber或message或signature为空");
            }
            BigInteger serialNumber16Radix = new BigInteger(serialNumber, 16);
            Map<BigInteger, X509Certificate> merchantCertificates;
            try {
                merchantCertificates = downloadCert();
            } catch (Exception ex) {
                throw new RuntimeException("下载证书失败", ex);
            }
            X509Certificate certificate = merchantCertificates.get(serialNumber16Radix);
            if (certificate == null) {
                return false;
            }
            try {
                Signature sign = Signature.getInstance("SHA256withRSA");
                sign.initVerify(certificate);
                sign.update(message);
                return sign.verify(Base64.getDecoder().decode(signature));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("当前Java环境不支持SHA256withRSA", e);
            } catch (SignatureException e) {
                throw new RuntimeException("签名验证过程发生了错误", e);
            } catch (InvalidKeyException e) {
                throw new RuntimeException("无效的证书", e);
            }
        }

        @Override
        public X509Certificate getValidCertificate() {
            return null;
        }
    }

    public MakeH5PayUrlResponse makeH5PayUrl(MakePayUrlRequest request) throws WechatPayException {
        request.setMchid(merchantId);
        return postJSON("https://api.mch.weixin.qq.com/v3/pay/transactions/h5", request, MakeH5PayUrlResponse.class);
    }

    public MakeNativePayUrlResponse makeNativePayUrl(MakePayUrlRequest request) throws WechatPayException {
        request.setMchid(merchantId);
        return postJSON("https://api.mch.weixin.qq.com/v3/pay/transactions/native", request,
                MakeNativePayUrlResponse.class);
    }

    public PayNotification decodePayNotification(String body, Map<String, String> headers) throws WechatPayException {
        NotificationRequest request = new NotificationRequest.Builder()
                .withSerialNumber(headers.get("Wechatpay-Serial")).withNonce(headers.get("Wechatpay-Nonce"))
                .withTimestamp(headers.get("Wechatpay-Timestamp")).withSignature(headers.get("Wechatpay-Signature"))
                .withBody(body).build();
        NotificationHandler handler = new NotificationHandler(new DefaultVerifier(),
                apiV3Key.getBytes(StandardCharsets.UTF_8));
        // 验签和解析请求体
        Notification notification;
        try {
            notification = handler.parse(request);
        } catch (ValidationException | ParseException e) {
            throw new WechatPayException("PARSE", "解析异常");
        }
        return Bean.fromJson(notification.getDecryptData(), new PayNotification());
    }

    public RefundResponse refund(RefundRequest request) throws WechatPayException {
        return postJSON("https://api.mch.weixin.qq.com/v3/refund/domestic/refunds", request, RefundResponse.class);
    }

    public RefundResponse queryRefund(String outRefundNo) throws WechatPayException {
        return get("https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/" + outRefundNo, RefundResponse.class);
    }
}

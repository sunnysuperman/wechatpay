package com.sunnysuperman.wechatpay.contrib.apache.httpclient;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.execchain.ClientExecChain;

import com.sunnysuperman.wechatpay.contrib.apache.httpclient.auth.CertificatesVerifier;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.sunnysuperman.wechatpay.contrib.apache.httpclient.auth.WechatPay2Validator;

/**
 * @author xy-peng
 */
public class WechatPayHttpClientBuilder extends HttpClientBuilder {

    private static final String OS = System.getProperty("os.name") + "/" + System.getProperty("os.version");
    private static final String VERSION = System.getProperty("java.version");
    private Credentials credentials;
    private Validator validator;

    private WechatPayHttpClientBuilder() {
        super();

        String userAgent = String.format("WechatPay-Apache-HttpClient/%s (%s) Java/%s",
                getClass().getPackage().getImplementationVersion(), OS, VERSION == null ? "Unknown" : VERSION);
        setUserAgent(userAgent);
    }

    public static WechatPayHttpClientBuilder create() {
        return new WechatPayHttpClientBuilder();
    }

    public WechatPayHttpClientBuilder withMerchant(String merchantId, String serialNo, PrivateKey privateKey) {
        this.credentials = new WechatPay2Credentials(merchantId, new PrivateKeySigner(serialNo, privateKey));
        return this;
    }

    public WechatPayHttpClientBuilder withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public WechatPayHttpClientBuilder withWechatPay(List<X509Certificate> certificates) {
        this.validator = new WechatPay2Validator(new CertificatesVerifier(certificates));
        return this;
    }

    public WechatPayHttpClientBuilder withValidator(Validator validator) {
        this.validator = validator;
        return this;
    }

    @Override
    public CloseableHttpClient build() {
        if (credentials == null) {
            throw new IllegalArgumentException("????????????????????????");
        }
        if (validator == null) {
            throw new IllegalArgumentException("????????????????????????");
        }
        return super.build();
    }

    @Override
    protected ClientExecChain decorateProtocolExec(final ClientExecChain requestExecutor) {
        return new SignatureExec(this.credentials, this.validator, requestExecutor);
    }

}

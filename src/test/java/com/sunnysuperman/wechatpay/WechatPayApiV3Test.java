package com.sunnysuperman.wechatpay;

import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.wechatpay.data.MakePayUrlRequest;
import com.sunnysuperman.wechatpay.data.PayNotification;
import com.sunnysuperman.wechatpay.data.MakePayUrlRequest.PayUrlRequestAmount;
import com.sunnysuperman.wechatpay.data.MakePayUrlRequest.PayUrlRequestSceneInfo;

import junit.framework.TestCase;

public class WechatPayApiV3Test extends TestCase {
    String merchantId = "";

    private WechatPayApiV3 getPayApi() throws Exception {
        String certSerialNum = "xx";
        String cert = FileUtil.read("xx.pem");
        String apiV3Key = "xx";
        WechatPayApiV3 api = new WechatPayApiV3(merchantId, certSerialNum, cert, apiV3Key);
        return api;
    }

    public void test_makeNativePayUrl() throws Exception {
        WechatPayApiV3 api = getPayApi();

        MakePayUrlRequest request = new MakePayUrlRequest();
        request.setAppid("xx");
        request.setOut_trade_no("dev" + System.currentTimeMillis());
        request.setDescription("商品描述");
        request.setNotify_url("https://xx.com/wxpay/" + merchantId);
        request.setAmount(new PayUrlRequestAmount(1));

        PayUrlRequestSceneInfo sceneInfo = new PayUrlRequestSceneInfo();
        sceneInfo.setPayer_client_ip("127.0.0.1");
        request.setScene_info(sceneInfo);

        String payUrl = api.makeNativePayUrl(request).getCode_url();
        System.out.println(payUrl);
    }

    public void test_decodePayNotification() throws Exception {
        WechatPayApiV3 api = getPayApi();
        Map<String, String> headers = new HashMap<>();
        headers.put("Wechatpay-Nonce", "xx");
        headers.put("Wechatpay-Serial", "xx");
        headers.put("Wechatpay-Timestamp", "xx");
        headers.put("Wechatpay-Signature", "xx");
        String body = "{\"id\":\"a3d4189f-e676-5335-b927-b42ba9d738b5\",\"create_time\":\"2022-04-21T20:45:00+08:00\",\"resource_type\":\"encrypt-resource\",\"event_type\":\"TRANSACTION.SUCCESS\",\"summary\":\"支付成功\",\"resource\":{\"original_type\":\"transaction\",\"algorithm\":\"AEAD_AES_256_GCM\",\"ciphertext\":\"dj7zjvs2IyUdTLPb/Pr6SLmjj/9VTKhSgifDTFihsEs0bSTmYve6NQH8EnHTxoUbSCFCewdzgXdli/Ti0uKaMzowAfMwdLptGf97ItDKLszWfGcMiQxq2p09ra38WkRR/HpSgxEZSrJgS0R0LsYh6nyPYAkHPAU86Vo2qZFaVot00v4+yxp6GUzCNzMZnMUUI7wazjKda9mrP2/EhvpEM0skNCg9K/HNKUZQ/+BeMHmm83vsaXYso4MnXqLILLWHkAkLxvXjiwwR3x8D/inzffx5SzNrORlrPfd/SjbFvnBhLTJ+D6f1jokLOVyeq3LyPmkJXa+CLQXx4MUzYnUIMcorx3L3d0R7HO/aHOz7jXUC/+aa8Df14e5WhXPWPZ8aSYyMaiqDFApirVyo6+sD9KmPltpcUouqNGXeS3l8XbaqbqIqqgbfg/nrGQSfUFS9WcHa/LjoGquGIg8VoHQN/1/XWU2N2AVbHvtZlFvcMQ0hh7nYwQqyNYUpJmzabXryDzmN0dcg6fAziz+kas5aWy+cWIX4vkeTtc0uhA4Va7IHFEAbI+EP6IhSRN5QN8qg\",\"associated_data\":\"transaction\",\"nonce\":\"HEOU0OE2Ctnq\"}}";

        PayNotification decoded = api.decodePayNotification(body, headers);
        System.out.println(JSONUtil.toJSONString(decoded));
    }

}

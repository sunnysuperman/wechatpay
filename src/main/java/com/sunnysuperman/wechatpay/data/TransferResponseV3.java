package com.sunnysuperman.wechatpay.data;

/**
 * @see <a href=
 *      "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml">微信支付-发起商家转账API</a>
 */
public class TransferResponseV3 {

    private String out_batch_no;
    private String batch_id;
    private String create_time;

    public String getOut_batch_no() {
        return out_batch_no;
    }

    public void setOut_batch_no(String out_batch_no) {
        this.out_batch_no = out_batch_no;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}

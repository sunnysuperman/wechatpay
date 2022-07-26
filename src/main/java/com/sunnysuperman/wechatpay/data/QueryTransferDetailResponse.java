package com.sunnysuperman.wechatpay.data;

/**
 * @see <a href=
 *      "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_6.shtml">商家明细单号查询明细单API</a>
 */
public class QueryTransferDetailResponse {

    private String out_batch_no;
    private String batch_id;
    private String appid;
    private String out_detail_no;
    private String detail_id;
    private String detail_status;
    private Integer transfer_amount;
    private String transfer_remark;
    private String fail_reason;
    private String openid;
    private String user_name;
    private String initiate_time;
    private String update_time;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOut_detail_no() {
        return out_detail_no;
    }

    public void setOut_detail_no(String out_detail_no) {
        this.out_detail_no = out_detail_no;
    }

    public String getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(String detail_id) {
        this.detail_id = detail_id;
    }

    public String getDetail_status() {
        return detail_status;
    }

    public void setDetail_status(String detail_status) {
        this.detail_status = detail_status;
    }

    public Integer getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(Integer transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public String getTransfer_remark() {
        return transfer_remark;
    }

    public void setTransfer_remark(String transfer_remark) {
        this.transfer_remark = transfer_remark;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getInitiate_time() {
        return initiate_time;
    }

    public void setInitiate_time(String initiate_time) {
        this.initiate_time = initiate_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public boolean processing() {
        return this.detail_status.equals("PROCESSING");
    }

    public boolean success() {
        return this.detail_status.equals("SUCCESS");
    }

    public boolean fail() {
        return this.detail_status.equals("FAIL");
    }
}

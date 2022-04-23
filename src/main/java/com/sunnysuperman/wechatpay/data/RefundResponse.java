package com.sunnysuperman.wechatpay.data;

public class RefundResponse {
    private String refund_id;
    private String out_refund_no;
    private String transaction_id;
    private String out_trade_no;
    private String channel;
    private String user_received_account;
    private String success_time;
    private String create_time;
    private String status;
    private String funds_account;

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUser_received_account() {
        return user_received_account;
    }

    public void setUser_received_account(String user_received_account) {
        this.user_received_account = user_received_account;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFunds_account() {
        return funds_account;
    }

    public void setFunds_account(String funds_account) {
        this.funds_account = funds_account;
    }

}

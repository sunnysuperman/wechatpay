package com.sunnysuperman.wechatpay.data;

public class PayNotification {
    public static class PayNotificationPayer {
        private String openid;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

    }

    public static class PayNotificationAmount {
        private int total;
        private int payer_total;
        private String currency;
        private String payer_currency;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPayer_total() {
            return payer_total;
        }

        public void setPayer_total(int payer_total) {
            this.payer_total = payer_total;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getPayer_currency() {
            return payer_currency;
        }

        public void setPayer_currency(String payer_currency) {
            this.payer_currency = payer_currency;
        }

    }

    private String appid;
    private String mchid;
    private String out_trade_no;
    private String transaction_id;
    private String trade_type;
    private String trade_state;
    private String bank_type;
    private String success_time;
    private String attach;
    private PayNotificationPayer payer;
    private PayNotificationAmount amount;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public PayNotificationPayer getPayer() {
        return payer;
    }

    public void setPayer(PayNotificationPayer payer) {
        this.payer = payer;
    }

    public PayNotificationAmount getAmount() {
        return amount;
    }

    public void setAmount(PayNotificationAmount amount) {
        this.amount = amount;
    }

}

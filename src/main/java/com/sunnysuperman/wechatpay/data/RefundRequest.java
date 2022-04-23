package com.sunnysuperman.wechatpay.data;

import java.util.List;

public class RefundRequest {
    public static class RefundRequestAmount {
        private int refund;
        private int total;
        private String currency = "CNY";

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

    }

    public static class RefundRequestGoodsDetail {
        private String merchant_goods_id;
        private String wechatpay_goods_id;
        private String goods_name;
        private int unit_price;
        private int refund_amount;
        private int refund_quantity;

        public String getMerchant_goods_id() {
            return merchant_goods_id;
        }

        public void setMerchant_goods_id(String merchant_goods_id) {
            this.merchant_goods_id = merchant_goods_id;
        }

        public String getWechatpay_goods_id() {
            return wechatpay_goods_id;
        }

        public void setWechatpay_goods_id(String wechatpay_goods_id) {
            this.wechatpay_goods_id = wechatpay_goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(int unit_price) {
            this.unit_price = unit_price;
        }

        public int getRefund_amount() {
            return refund_amount;
        }

        public void setRefund_amount(int refund_amount) {
            this.refund_amount = refund_amount;
        }

        public int getRefund_quantity() {
            return refund_quantity;
        }

        public void setRefund_quantity(int refund_quantity) {
            this.refund_quantity = refund_quantity;
        }
    }

    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String reason;
    private String notify_url;
    private String funds_account;
    private RefundRequestAmount amount;
    private List<RefundRequestGoodsDetail> goods_detail;

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

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getFunds_account() {
        return funds_account;
    }

    public void setFunds_account(String funds_account) {
        this.funds_account = funds_account;
    }

    public RefundRequestAmount getAmount() {
        return amount;
    }

    public void setAmount(RefundRequestAmount amount) {
        this.amount = amount;
    }

    public List<RefundRequestGoodsDetail> getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(List<RefundRequestGoodsDetail> goods_detail) {
        this.goods_detail = goods_detail;
    }

}

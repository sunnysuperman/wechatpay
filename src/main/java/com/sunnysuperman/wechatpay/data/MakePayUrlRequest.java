package com.sunnysuperman.wechatpay.data;

public class MakePayUrlRequest {
    public static class PayUrlRequestAmount {
        private int total;
        private String currency = "CNY";

        public PayUrlRequestAmount() {
            super();
        }

        public PayUrlRequestAmount(int total) {
            super();
            this.total = total;
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

    public static class PayUrlRequestSceneInfo {
        private String payer_client_ip;
        private String device_id;
        private PayUrlRequestStoreInfo store_info;
        private PayUrlRequestH5Info h5_info; // 只有H5有

        public String getPayer_client_ip() {
            return payer_client_ip;
        }

        public void setPayer_client_ip(String payer_client_ip) {
            this.payer_client_ip = payer_client_ip;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public PayUrlRequestStoreInfo getStore_info() {
            return store_info;
        }

        public void setStore_info(PayUrlRequestStoreInfo store_info) {
            this.store_info = store_info;
        }

        public PayUrlRequestH5Info getH5_info() {
            return h5_info;
        }

        public void setH5_info(PayUrlRequestH5Info h5_info) {
            this.h5_info = h5_info;
        }

    }

    public static class PayUrlRequestH5Info {
        private String type;
        private String app_name;
        private String app_url;
        private String bundle_id;
        private String package_name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getBundle_id() {
            return bundle_id;
        }

        public void setBundle_id(String bundle_id) {
            this.bundle_id = bundle_id;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

    }

    public static class PayUrlRequestStoreInfo {
        private String id;
        private String name;
        private String area_code;
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class PayUrlRequestSettleInfo {
        private String profit_sharing;

        public String getProfit_sharing() {
            return profit_sharing;
        }

        public void setProfit_sharing(String profit_sharing) {
            this.profit_sharing = profit_sharing;
        }
    }

    private String appid;
    private String mchid;
    private String description;
    private String out_trade_no;
    private String time_expire;
    private String attach;
    private String notify_url;
    private String goods_tag;
    private PayUrlRequestAmount amount;
    private PayUrlRequestSceneInfo scene_info;
    private PayUrlRequestSettleInfo settle_info;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public PayUrlRequestAmount getAmount() {
        return amount;
    }

    public void setAmount(PayUrlRequestAmount amount) {
        this.amount = amount;
    }

    public PayUrlRequestSceneInfo getScene_info() {
        return scene_info;
    }

    public void setScene_info(PayUrlRequestSceneInfo scene_info) {
        this.scene_info = scene_info;
    }

    public PayUrlRequestSettleInfo getSettle_info() {
        return settle_info;
    }

    public void setSettle_info(PayUrlRequestSettleInfo settle_info) {
        this.settle_info = settle_info;
    }

}

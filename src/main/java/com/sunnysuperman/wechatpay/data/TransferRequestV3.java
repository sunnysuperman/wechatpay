package com.sunnysuperman.wechatpay.data;

/**
 * @see <a href=
 *      "https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml">微信支付-发起商家转账API</a>
 */
public class TransferRequestV3 {

    public static class TransferDetail {

        private String out_detail_no;
        private int transfer_amount;
        private String transfer_remark;
        private String openid;
        private String user_name;

        public String getOut_detail_no() {
            return out_detail_no;
        }

        public void setOut_detail_no(String out_detail_no) {
            this.out_detail_no = out_detail_no;
        }

        public int getTransfer_amount() {
            return transfer_amount;
        }

        public void setTransfer_amount(int transfer_amount) {
            this.transfer_amount = transfer_amount;
        }

        public String getTransfer_remark() {
            return transfer_remark;
        }

        public void setTransfer_remark(String transfer_remark) {
            this.transfer_remark = transfer_remark;
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
    }

    private String appid;
    private String out_batch_no;
    private String batch_name;
    private String batch_remark;
    private int total_amount;
    private int total_num;
    private TransferDetail[] transfer_detail_list;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOut_batch_no() {
        return out_batch_no;
    }

    public void setOut_batch_no(String out_batch_no) {
        this.out_batch_no = out_batch_no;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getBatch_remark() {
        return batch_remark;
    }

    public void setBatch_remark(String batch_remark) {
        this.batch_remark = batch_remark;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public TransferDetail[] getTransfer_detail_list() {
        return transfer_detail_list;
    }

    public void setTransfer_detail_list(TransferDetail[] transfer_detail_list) {
        this.transfer_detail_list = transfer_detail_list;
    }
}

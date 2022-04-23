package com.sunnysuperman.wechatpay;

public class WechatPayException extends Exception {
    private static final long serialVersionUID = -5587135821237511999L;

    private String errCode;
    private String errMessage;

    public WechatPayException(String errCode, String errMessage) {
        super();
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

}

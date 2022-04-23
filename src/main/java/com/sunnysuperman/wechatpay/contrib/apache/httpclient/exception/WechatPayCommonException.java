package com.sunnysuperman.wechatpay.contrib.apache.httpclient.exception;

/**
 * @author lianup
 */
public abstract class WechatPayCommonException extends Exception {

    private static final long serialVersionUID = -5059029681600588999L;

    public WechatPayCommonException(String message) {
        super(message);
    }

    public WechatPayCommonException(String message, Throwable cause) {
        super(message, cause);
    }

}

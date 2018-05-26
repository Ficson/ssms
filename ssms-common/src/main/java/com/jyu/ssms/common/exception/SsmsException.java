package com.jyu.ssms.common.exception;

public class SsmsException extends RuntimeException{
    private String msg;

    public SsmsException(String msg){
        super(msg);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

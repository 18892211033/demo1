package com.isoft.demo.bean;

import java.io.Serializable;

public class ResponseData implements Serializable {
    private int errCode;
    private String msg;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(int errCode, String msg, Object data) {
        this.errCode = errCode;
        this.msg = msg;
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "errCode=" + errCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

package com.hanna.first.springbootprj.config.auth.dto;

public class EntryPointErrorResponse {

    private String msg;

    public EntryPointErrorResponse() {
    }

    public EntryPointErrorResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

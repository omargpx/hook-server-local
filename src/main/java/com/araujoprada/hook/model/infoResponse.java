package com.araujoprada.hook.model;

import lombok.Data;

@Data
public class infoResponse {
    private String url;
    private String message;
    private Object detail;

    public infoResponse(String url, String message,Object detail) {
        this.url = url;
        this.message = message;
        this.detail = detail;
    }
}

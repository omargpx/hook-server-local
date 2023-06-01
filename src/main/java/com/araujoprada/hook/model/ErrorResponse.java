package com.araujoprada.hook.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends Error {
    private String url;
    private String origin;
    private String status;

    public ErrorResponse(String message, String url, String origin, String status) {
        super(message);
        this.url = url;
        this.origin = origin;
        this.status = status;
    }
}

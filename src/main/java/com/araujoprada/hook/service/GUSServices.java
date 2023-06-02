package com.araujoprada.hook.service;

import com.araujoprada.hook.model.GUSResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Map;

public interface GUSServices {
    Map<String,String> getSpecificHeaders(HttpServletRequest request);
    String getCurrentYear();
    String genSecureCode(String acronym);
    GUSResponse getResponse(HttpServletRequest url, String className,Object data, HttpStatus status);
    String genIdentificationCode(String acronym);
    Object OAuthAccountLoginCredential(String identify);
}

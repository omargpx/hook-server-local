package com.araujoprada.hook.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface GUSServices {
    Map<String,String> getSpecificHeaders(HttpServletRequest request);
    String getCurrentYear();
    String genSecureCode();
}

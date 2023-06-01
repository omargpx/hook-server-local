package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.model.GUSResponse;
import com.araujoprada.hook.service.GUSServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GUSImp implements GUSServices {

    //region attributes
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678987654321abcdefghijklmnñopqrstuvxyz";
    private static final SecureRandom sr = new SecureRandom();
    //endregion

    @Override
    public Map<String, String> getSpecificHeaders(HttpServletRequest request) {
        Map<String, String> specificHeaders = new HashMap<>();
        specificHeaders.put("connection", request.getHeader("connection"));
        specificHeaders.put("sec-ch-ua", request.getHeader("sec-ch-ua"));
        specificHeaders.put("sec-ch-ua-platform", request.getHeader("sec-ch-ua-platform"));
        specificHeaders.put("hook_info","/info");
        return specificHeaders;
    }

    @Override
    public String getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return Integer.toString(year).substring(2);
    }

    @Override
    public String genSecureCode(String acronym) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int index = sr.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return acronym+getCurrentYear()+"-"+builder.toString();
    }

    @Override
    public GUSResponse getResponse(HttpServletRequest url, String className, Object data, HttpStatus status) {
        return new GUSResponse(url.getRequestURI(),className,data,status.name());
    }

    @Override
    public String genIdentificationCode(String acronym) {
        Random random = new Random();
        return acronym+getCurrentYear()+"-"+random.nextInt(999999999);
    }
}

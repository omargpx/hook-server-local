package com.araujoprada.hook.controller;

import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.service.GUSServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.araujoprada.hook.model.InfoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping
public class GUSController {

    @Autowired
    private GUSServices gus;
    @Autowired
    private Environment env;
    private final ResourceLoader resourceLoader;

    public GUSController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @RequestMapping
    public ResponseEntity<?> handleWelcome(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        InfoResponse response = new InfoResponse(url,"Welcome to hook application",gus.getSpecificHeaders(request));
        return new ResponseEntity<>(response, HttpStatus.PARTIAL_CONTENT);
    }
    @RequestMapping(value = "/info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> handleInfo(HttpServletRequest request) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:info.json");
        String jsonContent = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return new ResponseEntity<>(jsonContent, HttpStatus.PARTIAL_CONTENT);
    }
    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public ResponseEntity<?> authAccountLogin(HttpServletRequest request,
                                              @RequestParam(name = "token")String TOKEN,
                                              @RequestParam(name = "identify")String identify){
        if(!Objects.equals(TOKEN, env.getProperty("config.hook-access.security-token-permission")))
            throw new GUSException(SERVICES.GUS_SERVICE.name(), null, HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(gus.getResponse(request,SERVICES.GUS_SERVICE.name(), gus.OAuthAccountLoginCredential(identify),HttpStatus.OK));
    }
    @RequestMapping("/**")
    public ResponseEntity<?> handleInvalidRequest(HttpServletRequest request) {
        InfoResponse response = new InfoResponse(request.getRequestURL().toString(),"Non-existent URL in hook_server. check the path entered",null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}

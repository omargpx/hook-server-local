package com.araujoprada.hook.controller;

import com.araujoprada.hook.service.GUSServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.araujoprada.hook.model.infoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
@RestController
@RequestMapping
public class GUSController {

    @Autowired
    private GUSServices gus;

    private final ResourceLoader resourceLoader;

    public GUSController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @RequestMapping
    public ResponseEntity<?> handleWelcome(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        infoResponse response = new infoResponse(url,"Welcome to hook application",gus.getSpecificHeaders(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> handleInfo(HttpServletRequest request) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:info.json");
        String jsonContent = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return new ResponseEntity<>(jsonContent, HttpStatus.OK);
    }
    @RequestMapping("/**")
    public ResponseEntity<?> handleInvalidRequest(HttpServletRequest request) {
        infoResponse response = new infoResponse(request.getRequestURL().toString(),"Non-existent URL in hook_server. check the path entered",null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}

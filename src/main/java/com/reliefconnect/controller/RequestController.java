package com.reliefconnect.controller;

import com.reliefconnect.model.Request;
import com.reliefconnect.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin("*")
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public Request create(@RequestBody Request request) {
        return service.save(request);
    }

    @GetMapping
    public List<Request> getAll() {
        return service.getAll();
    }
}
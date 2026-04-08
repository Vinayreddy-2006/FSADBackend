package com.reliefconnect.service;

import com.reliefconnect.model.Request;
import com.reliefconnect.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repo;

    public Request save(Request request) {
        return repo.save(request);
    }

    public List<Request> getAll() {
        return repo.findAll();
    }
}
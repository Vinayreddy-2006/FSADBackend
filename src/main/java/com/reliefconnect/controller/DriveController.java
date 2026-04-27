package com.reliefconnect.controller;

import com.reliefconnect.model.Drive;
import com.reliefconnect.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drives")
@CrossOrigin("https://effulgent-haupia-2b6500.netlify.app/")
public class DriveController {

    @Autowired
    private DriveService service;

    @PostMapping
    public Drive create(@RequestBody Drive drive) {
        System.out.println("Received 👉 " + drive.getTitle());
        return service.save(drive);
    }

    @GetMapping
    public List<Drive> getAll() {
        return service.getAll();
    }
}
package com.reliefconnect.controller;

import com.reliefconnect.repository.DonationRepository;
import com.reliefconnect.repository.DriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "https://effulgent-haupia-2b6500.netlify.app")
public class DashboardController {

    @Autowired
    private DonationRepository donationRepo;

    @Autowired
    private DriveRepository driveRepo;

    @GetMapping
    public Map<String, Object> stats() {
        Map<String, Object> map = new HashMap<>();
        map.put("donations", donationRepo.count());
        map.put("drives", driveRepo.count());
        return map;
    }
}
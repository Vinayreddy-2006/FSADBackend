package com.reliefconnect.controller;

import com.reliefconnect.model.Donation;
import com.reliefconnect.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/donations")
@CrossOrigin("https://effulgent-haupia-2b6500.netlify.app/")
public class DonationController {

    @Autowired
    private DonationService service;

    @PostMapping
    public Donation create(@RequestBody Donation donation) {
        return service.save(donation);
    }

    @GetMapping
    public List<Donation> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Donation updateDonation(@PathVariable("id") Long id,
                                   @RequestBody Donation updatedDonation) {

        Donation donation = service.getById(id);

        if (donation == null) {
            throw new RuntimeException("Donation not found");
        }

        donation.setStatus(updatedDonation.getStatus());

        return service.save(donation);
    }
}
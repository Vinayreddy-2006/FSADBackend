package com.reliefconnect.service;

import com.reliefconnect.model.Donation;
import com.reliefconnect.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonationService {

    @Autowired
    private DonationRepository repo;

    public Donation save(Donation donation) {
        return repo.save(donation);
    }

    public List<Donation> getAll() {
        return repo.findAll();
    }

    // 🔥 ADD THIS
    public Donation getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
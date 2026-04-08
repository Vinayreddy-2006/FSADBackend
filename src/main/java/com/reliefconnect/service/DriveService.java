package com.reliefconnect.service;

import com.reliefconnect.model.Drive;
import com.reliefconnect.repository.DriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveService {

    @Autowired
    private DriveRepository repository;

    public Drive save(Drive drive) {
        System.out.println("Saving Drive 👉 " + drive.getTitle());
        return repository.save(drive);   // ✅ MUST RETURN
    }

    public List<Drive> getAll() {
        return repository.findAll();
    }

    public Drive getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
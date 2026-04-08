package com.reliefconnect.repository;

import com.reliefconnect.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
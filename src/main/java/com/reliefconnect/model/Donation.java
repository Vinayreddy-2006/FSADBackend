package com.reliefconnect.model;

import jakarta.persistence.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private int quantity;
    private String status;

    // 🔥 LINK TO USER (DONOR)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor;

    // 🔥 LINK TO DRIVE (VERY IMPORTANT)
    @ManyToOne
    @JoinColumn(name = "drive_id")
    private Drive drive;

    // ✅ CONSTRUCTORS
    public Donation() {}

    public Donation(Long id, String item, int quantity, String status, User donor, Drive drive) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.status = status;
        this.donor = donor;
        this.drive = drive;
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public User getDonor() { return donor; }
    public Drive getDrive() { return drive; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setItem(String item) { this.item = item; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(String status) { this.status = status; }
    public void setDonor(User donor) { this.donor = donor; }
    public void setDrive(Drive drive) { this.drive = drive; }
}
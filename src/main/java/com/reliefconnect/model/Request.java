package com.reliefconnect.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private int quantity;
    private String location;
    private String priority;
    private String status;

    // 🔥 LINK TO USER
    @ManyToOne(fetch = FetchType.EAGER) // ✅ FIXED
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    // 🔥 LINK TO DRIVE (IMPORTANT FIX)
    @ManyToOne(fetch = FetchType.EAGER) // ✅ CHANGE FROM LAZY → EAGER
    @JoinColumn(name = "drive_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Drive drive;

    // ✅ CONSTRUCTOR
    public Request() {}

    public Request(Long id, String item, int quantity, String location,
                   String priority, String status, User user, Drive drive) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.location = location;
        this.priority = priority;
        this.status = status;
        this.user = user;
        this.drive = drive;
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public String getLocation() { return location; }
    public String getPriority() { return priority; }
    public String getStatus() { return status; }
    public User getUser() { return user; }
    public Drive getDrive() { return drive; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setItem(String item) { this.item = item; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setLocation(String location) { this.location = location; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setStatus(String status) { this.status = status; }
    public void setUser(User user) { this.user = user; }
    public void setDrive(Drive drive) { this.drive = drive; }
}
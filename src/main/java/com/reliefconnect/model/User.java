package com.reliefconnect.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; // ADMIN / DONOR / RECIPIENT

    // 🔥 LINK WITH DONATIONS
    @OneToMany(mappedBy = "donor")
    @JsonIgnore
    private List<Donation> donations;

    // 🔥 LINK WITH REQUESTS
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Request> requests;

    // ✅ DEFAULT CONSTRUCTOR
    public User() {}

    // ✅ PARAMETERIZED CONSTRUCTOR
    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public List<Donation> getDonations() { return donations; }
    public List<Request> getRequests() { return requests; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setDonations(List<Donation> donations) { this.donations = donations; }
    public void setRequests(List<Request> requests) { this.requests = requests; }
}
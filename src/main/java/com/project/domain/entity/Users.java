package com.project.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String password;
    private int balance;
    private LocalDateTime createAt;

    protected Users() {}

    public Users(Long userId, String name, String password, int balance, LocalDateTime createAt) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.createAt = createAt;
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public int getBalance() { return balance; }
    public LocalDateTime getCreateAt() { return createAt; }
}

package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="users_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "username")
    @NotEmpty
    private String username;

    @Column (name = "password")
    private String password;

    @Column (name = "email")
    @NotEmpty
    private String email;

    @Column (name = "first_name")
    @NotEmpty
    private String firstName;

    @Column (name = "last_name")
    @NotEmpty
    private String lastName;

    @Column (name = "enabled")
    private boolean enabled;

    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName, boolean enabled) {
        this.username = username;
        this.setPassword(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean enabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        enabled = enabled;
    }
}

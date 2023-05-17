package com.example.app.Security.ModelsJWT;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 32)
    private String nombre;

    @NotBlank
    @Size(max = 32)
    private String apellidoP;

    @NotBlank
    @Size(max = 32)
    private String apellidoM;

    @NotBlank
    @Size(max = 34)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    private Boolean active;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String nombre, String apellidoP, String apellidoM, String username, String password, Boolean active, LocalDateTime timestamp, String userstamp) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.username = username;
        this.password = password;
        this.active = active;
        this.timestamp = timestamp;
        this.userstamp = userstamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
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
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestampEdit() {
        return timestampEdit;
    }

    public void setTimestampEdit(LocalDateTime timestampEdit) {
        this.timestampEdit = timestampEdit;
    }

    public String getUserstamp() {
        return userstamp;
    }

    public void setUserstamp(String userstamp) {
        this.userstamp = userstamp;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

package com.example.ivd.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

    @Entity
    @EntityListeners(AuditingEntityListener.class)
    @Table(name="users")
    public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String emailId;
    @Column(name="created_at",nullable=false,updatable=false)
    private String regDate;

    @Column(name="modified_date")
    @LastModifiedDate
    private long lastmodifed;


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> hasrole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Unit units;

    @OneToMany(targetEntity = notification.class, mappedBy = "id", orphanRemoval = false,
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Set<notification> notifies;
    private Set<reports> reports;

    public User() {

    }

    public User(int id, String username, String firstname, String lastname, String password, String emailId, Set<Role> hasrole, Unit units, Set<notification> notifies, Set<com.example.ivd.model.reports> reports) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.emailId = emailId;
        this.hasrole = hasrole;
        this.units = units;
        this.notifies = notifies;
        this.reports = reports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<Role> getHasrole() {
        return hasrole;
    }

    public void setHasrole(Set<Role> hasrole) {
        this.hasrole = hasrole;
    }

    public Unit getUnits() {
        return units;
    }

    public void setUnits(Unit units) {
        this.units = units;
    }

    public Set<notification> getNotifies() {
        return notifies;
    }

    public void setNotifies(Set<notification> notifies) {
        this.notifies = notifies;
    }

    public Set<com.example.ivd.model.reports> getReports() {
        return reports;
    }

    public void setReports(Set<com.example.ivd.model.reports> reports) {
        this.reports = reports;
    }
}
package com.example.ivd.model;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="units")
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String description;

    @Column(name="created_at",nullable=false,updatable =false)
    private String regDate;

    @Column(name="modified_date")
    @LastModifiedDate
    private long lastmodifed;

    @OneToMany(targetEntity = User.class, mappedBy = "id",orphanRemoval = false,
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="unitId",referencedColumnName = "id")
    private Set<User> users;

    public Unit() {
    }

    public Unit(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.ivd.model;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String description;
    @Column(name="created_at",nullable=false,updatable=false)
    private String regDate;

    @Column(name="modified_date")
    @LastModifiedDate
    private long lastmodifed;

   @ManyToMany(mappedBy = "hasrole")
   private Set<User> ownrole;


    public Role() {
    }

    public Role(int id, String name, String description, Set<User> ownrole) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownrole = ownrole;
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

    public Set<User> getOwnrole() {
        return ownrole;
    }

    public void setOwnrole(Set<User> ownrole) {
        this.ownrole = ownrole;
    }
}

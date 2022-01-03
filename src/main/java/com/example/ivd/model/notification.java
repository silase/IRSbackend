package com.example.ivd.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="notifications")
@EntityListeners(AuditingEntityListener.class)
public class notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private String status;

    @Column(name="created_at",nullable=false,updatable=false)
    private String regDate;

    @Column(name="modified_date")
    @LastModifiedDate
    private long lastmodifed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private User users;

}

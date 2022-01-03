package com.example.ivd.repository;

import com.example.ivd.model.notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface notificationRepository extends JpaRepository<notification,Integer> {
    public List<notification> findByTitle(String title);
    public List<notification> findByUsername(String username);
    public List<notification> findByLastModified_date(String mdate);

}

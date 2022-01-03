package com.example.ivd.repository;

import com.example.ivd.model.reports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reportRepository extends JpaRepository<reports,Integer> {
    public reports findByTitle(String title);
    public reports findByModified_date(String mdate);
}

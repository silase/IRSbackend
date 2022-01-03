package com.example.ivd.repository;

import com.example.ivd.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface unitRepo extends JpaRepository<Unit,Integer> {
    public Unit findByUnit(String units);
}

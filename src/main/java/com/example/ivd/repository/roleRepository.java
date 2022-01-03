package com.example.ivd.repository;

import com.example.ivd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<Role,Integer> {
    public Role findByRole(String role);

}

package com.example.ivd.repository;

import com.example.ivd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository  extends JpaRepository<User,Integer> {
    public User findByEmailId(String email);
    public User findByUsername(String username);
    public List<User> findUserByRole(String role);
    public List<User> findUserByUnit(String units);
    public User findByEmailAndPassword(String email,String password);
}

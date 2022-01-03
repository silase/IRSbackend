package com.example.ivd.service;

import com.example.ivd.model.User;
import com.example.ivd.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    RegistrationRepository regrepo;

    public User reguser(User users){
        return regrepo.save(users);
    }
    public User findByEmail(String email){
        return regrepo.findByEmailId(email);
    }
    public User findByUsername(String username){return regrepo.findByUsername(username);}
    public List<User> listuser(){ List registerdUser= regrepo.findAll(); return registerdUser;}

    public User findByEmailAndPassword(String email,String password){
        return regrepo.findByEmailAndPassword(email,password);
    }
    public List<User> findUserByRole(String roles){
    List roleusers=regrepo.findUserByRole(roles);
    return roleusers;
    }
}

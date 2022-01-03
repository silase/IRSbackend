package com.example.ivd.service;

import com.example.ivd.model.Role;
import com.example.ivd.repository.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class roleService {
    @Autowired
    roleRepository rolerepo;

    public Role addroles(Role roles){ return rolerepo.save(roles);}

    public Role findByRole(String role){
        return rolerepo.findByRole(role);
    }

    public List<Role> getrolelist(){List listrole=rolerepo.findAll(); return listrole; }
}

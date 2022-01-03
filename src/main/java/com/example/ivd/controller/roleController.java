package com.example.ivd.controller;

import com.example.ivd.model.Role;
import com.example.ivd.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class roleController {
    @Autowired
    private roleService rservice;

    @PostMapping("/addrole")
   private Role addrole(@RequestBody Role roles) throws  Exception {
   String rolename=roles.getName();
   String descriptions=roles.getDescription();
   if((rolename !=null && descriptions !=null) && (rolename!="" && descriptions!="")){
       Role roleObj=rservice.findByRole(rolename);
       if (roleObj!=null){
      throw new Exception("Role already exist " +rolename);
       }
   }
   Role roleObj=null;
   roleObj=rservice.addroles(roles);
        return roleObj;
   }

   @GetMapping("/viewrole")
    private Role viewroles(Role roles) throws  Exception{
        String rolename=roles.getName();
        Role roleObj;

        if (rolename!=""){
            roleObj=rservice.findByRole(rolename);
        }else{
            throw new Exception("role not exist");
        }

        return roleObj;
   }
}

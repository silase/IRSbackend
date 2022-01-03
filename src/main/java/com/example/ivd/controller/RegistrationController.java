package com.example.ivd.controller;

import com.example.ivd.model.User;
import com.example.ivd.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    RegisterService regservice;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User users)throws  Exception{
        String uemail= users.getEmailId();

        if (uemail!=null && uemail!="" ){
            User userObj=regservice.findByEmail(uemail);
            if(userObj!=null){
                throw new Exception("User already exist "+uemail);
            }
        }
        User userObj=null;
        userObj=regservice.reguser(users);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin(origins="http://localhost:4200")
    public User loginuser(@RequestBody User users) throws  Exception{
    String emailId=users.getEmailId();
    String password=users.getPassword();
    User userObj=null;
    if(emailId!=null && password!=null){
      userObj= regservice.findByEmailAndPassword(emailId,password);
    }
    if (userObj==null) {
        throw new Exception("User not found with that credential");
    }
    return userObj;
    }


}

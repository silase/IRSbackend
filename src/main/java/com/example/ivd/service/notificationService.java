package com.example.ivd.service;

import com.example.ivd.model.notification;
import com.example.ivd.repository.notificationRepository;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class notificationService {
    @Autowired
    notificationRepository notificationRepo;

    public notification addnotification(notification notify){
        return notificationRepo.save(notify);
    }
    public List<notification> findByTitle(String title){

        List titles=notificationRepo.findByTitle(title);
         return titles;
    }

    public List<notification> findByUsername(String username){
        List notifiedUsers=notificationRepo.findByUsername(username);
        return notifiedUsers;
    }

    public List<notification> findBymodifieddate(String mdate){
        List notificationmodifieddate=notificationRepo.findByLastModified_date(mdate);
        return notificationmodifieddate;
    }
}

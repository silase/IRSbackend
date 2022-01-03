package com.example.ivd.service;

import com.example.ivd.model.reports;
import com.example.ivd.repository.reportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reportService {
    @Autowired
    reportRepository reportRepo;
    public reports addreports(reports report){ return reportRepo.save(report); }
    public reports findByTitle (String title) {return  reportRepo.findByTitle(title);}
    public reports findBymodifieddate(String mdate){ return reportRepo.findByModified_date(mdate); }

}

package com.example.ivd.service;

import com.example.ivd.model.Unit;
import com.example.ivd.repository.unitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class unitService {

    @Autowired
    unitRepo unitsrepo;

    public Unit addunit(Unit units){
        return unitsrepo.save(units);
    }

    public Unit findByUnit(String unitname){
        return unitsrepo.findByUnit(unitname);
    }

    public List<Unit> findAllUnits(){ return unitsrepo.findAll(); }
}

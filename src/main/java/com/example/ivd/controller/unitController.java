package com.example.ivd.controller;

import com.example.ivd.model.Unit;
import com.example.ivd.service.unitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class unitController {

    @Autowired
    unitService uservice;

    @PostMapping("/addunit")
    public Unit addunits(Unit units) throws Exception{
        String name=units.getName();
        String descpt=units.getDescription();

        if ((name!=null && descpt!=null) && (name!="" && descpt!="")){
            Unit unitObj=uservice.findByUnit(name);
            if (unitObj!=null) {
                throw new Exception("Unit already exist "+name);
            }

            }
        Unit unitObj=null;
        unitObj=uservice.addunit(units);
        return unitObj;
        }

        @GetMapping("/viewunits")
        public Unit getUnits(Unit units) throws Exception{
        String name=units.getName();
        Unit unitObj=null;
        if (name!=""){
         unitObj=uservice.findByUnit(name);
        }else{
            throw  new Exception("Units is not found");
        }
        return unitObj;
        }

}

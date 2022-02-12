package com.springcloud.accountservice.controller;


import com.springcloud.accountservice.entity.Unit;
import com.springcloud.accountservice.service.UnitSerivce;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/unit")
public class UnitController {

    @Resource
    private UnitSerivce unitSerivce;

    @RequestMapping("/getunit")
    public Unit getUnit(String unitName) {
        return unitSerivce.findByUnitName(unitName);
    }

}

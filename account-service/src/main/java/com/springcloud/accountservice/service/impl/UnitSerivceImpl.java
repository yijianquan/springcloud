package com.springcloud.accountservice.service.impl;

import com.springcloud.accountservice.entity.Unit;
import com.springcloud.accountservice.repository.UnitRepository;
import com.springcloud.accountservice.service.UnitSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UnitSerivceImpl implements UnitSerivce {

    @Resource
    private UnitRepository unitRepository;

    @Override
    public Unit findByUnitName(String unitName) {
        return unitRepository.findByUnitName(unitName);
    }
}

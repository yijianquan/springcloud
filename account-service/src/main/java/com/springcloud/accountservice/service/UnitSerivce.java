package com.springcloud.accountservice.service;

import com.springcloud.accountservice.entity.Unit;

public interface UnitSerivce {

    Unit findByUnitName(String unitName);
}

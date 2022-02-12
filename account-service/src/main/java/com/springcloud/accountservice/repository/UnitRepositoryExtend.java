package com.springcloud.accountservice.repository;

import com.springcloud.accountservice.dto.Area;
import com.springcloud.accountservice.entity.Unit;

import java.util.List;

public interface UnitRepositoryExtend {
    List<Unit> findByArea(Area area);
}

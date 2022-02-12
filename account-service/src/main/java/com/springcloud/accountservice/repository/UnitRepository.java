package com.springcloud.accountservice.repository;

import com.springcloud.accountservice.entity.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends MongoRepository<Unit, String>, UnitRepositoryExtend {
    Unit findByUnitName(String UnitName);
}


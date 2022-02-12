package com.springcloud.accountservice.repository.mongoextend;

import com.springcloud.accountservice.dto.Area;
import com.springcloud.accountservice.entity.Unit;
import com.springcloud.accountservice.repository.UnitRepositoryExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnitRepositoryExtendImpl implements UnitRepositoryExtend {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Unit> findByArea(Area area) {
        mongoTemplate.aggregate(null, null);
        return null;
    }

}

package com.springcloud.accountservice.repository;

import com.springcloud.accountservice.entity.Teacher;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

//泛型第一个类型参数是封装数据的实体类，第二个类型参数是该实体类的主键类型（即标记了@Id的实例域的类型）
@Repository
public interface TeacherReposotory extends ElasticsearchRepository<Teacher,Integer> {
}

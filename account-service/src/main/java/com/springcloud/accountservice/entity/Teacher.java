package com.springcloud.accountservice.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "people", shards = 2, replicas = 1)
public class Teacher {
    @Id  /*标记为主键，不可少*/
    private Integer id;
}

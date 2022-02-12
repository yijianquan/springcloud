package com.springcloud.accountservice.service.impl;

import com.springcloud.accountservice.entity.Teacher;
import com.springcloud.accountservice.repository.TeacherReposotory;
import com.springcloud.accountservice.service.TeacherService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherReposotory teacherReposotory;

    @Override
    public void search() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        创建match查询对象（同理可用QueryBuilders.termQuery()创建term过滤对象）
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "小明");
//        确定该查询是and\not\or
        boolQueryBuilder.must(matchQueryBuilder);
//        获取返回数据，是个迭代器
        Iterable<Teacher> Iterable = teacherReposotory.search(boolQueryBuilder);
        for (Teacher teacher : Iterable) {
            System.out.println(teacher.toString());
        }
    }
}

package com.springcloud.babyservice.service.impl;

import com.springcloud.babyservice.service.BabyService;
import org.springframework.stereotype.Service;

@Service
public class BabyServiceImpl implements BabyService {

    @Override
    public String getBaby() {
        return "抓到娃娃了";
    }

}

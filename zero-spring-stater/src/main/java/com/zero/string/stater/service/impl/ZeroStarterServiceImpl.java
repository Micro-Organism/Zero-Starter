package com.zero.string.stater.service.impl;

import com.zero.string.stater.common.model.ZeroStarterProperties;
import com.zero.string.stater.service.ZeroStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZeroStarterServiceImpl implements ZeroStarterService {

    private final ZeroStarterProperties properties;

    @Autowired
    public ZeroStarterServiceImpl(ZeroStarterProperties properties) {
        this.properties = properties;
    }

    @Override
    public void sayHello() {
        String message = String.format("hi，my name: %s, today,I'am %s , gender: %s",
                properties.getName(), properties.getAge(), properties.getSex());
        System.out.println(message);
    }
}

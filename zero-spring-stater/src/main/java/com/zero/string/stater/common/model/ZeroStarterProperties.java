package com.zero.string.stater.common.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
@ConfigurationProperties(prefix = "zero")
public class ZeroStarterProperties implements Serializable {

    private String name;
    private String age;
    private String address;
    private String phone;
    private String email;
    private String sex;

}

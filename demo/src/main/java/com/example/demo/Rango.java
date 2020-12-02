package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.demo.application.resources.DemoResource;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("mi.rango")
public class Rango {
    private int min;
    private int max;    
}

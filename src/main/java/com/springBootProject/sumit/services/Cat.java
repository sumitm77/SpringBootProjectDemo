package com.springbootproject.sumit.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class Cat implements Animal{


    @Override
    public String characteristics() {
        return "Meow";
    }



}

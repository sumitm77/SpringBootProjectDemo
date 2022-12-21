package com.springbootproject.sumit.controller;

import com.springbootproject.sumit.services.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowired")
public class AutowiredController {
    //@Qualifier("dog")
    @Autowired
    private Animal animal;


    @GetMapping
    public String fetchDogCharacteristics() {
        return animal.characteristics();
    }
}

package com.example.controller;

import com.example.domain.Neeson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by daile on 2017/7/13.
 */
@RestController
public class NessonController {

    @Bean
    public Neeson currentNeeson(){
        Neeson neeson = new Neeson();
        neeson.setAge(20);
        neeson.setName("le");
        return neeson;
    }

    @Autowired
    @Qualifier("currentNeeson")
    private Neeson neeson;

    @GetMapping(value = "/json/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Neeson neeson(){
        neeson.add(linkTo(methodOn(NessonController.class).setName(neeson.getName())).withSelfRel());
        neeson.add(linkTo(methodOn(NessonController.class).setAge(neeson.getAge())).withSelfRel());
        return neeson;
    }

    @GetMapping(value = "/json/user/set/name",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Neeson setName(@RequestParam String name){
        neeson.setName(name);
        return neeson;
    }

    @GetMapping(value = "/json/user/set/age",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Neeson setAge(@RequestParam int age){
        neeson.setAge(age);
        return neeson;
    }
}

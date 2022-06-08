package com.killer.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comm")
public class commonController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}

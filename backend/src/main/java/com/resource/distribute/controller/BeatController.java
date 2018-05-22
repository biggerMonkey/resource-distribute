package com.resource.distribute.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
@RestController
@RequestMapping("/resource")
public class BeatController {

    @RequestMapping("/beat")
    public String beat() {
        return "alive";
    }
}

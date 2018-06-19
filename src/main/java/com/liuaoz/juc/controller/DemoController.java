package com.liuaoz.juc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : TODO
 * @Author : matrix
 * @Date : created in 2018/6/7 21:48
 */
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        log.info("demo test...");
        return ResponseEntity.ok("success.");
    }
}

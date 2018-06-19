package com.liuaoz.juc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoController {

    @GetMapping(value = "/")
    public ResponseEntity<String> home() {
        log.info("demo test...");
        return ResponseEntity.ok("welcome to my home.");
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        log.info("demo test...");
        return ResponseEntity.ok("test success.");
    }
    @GetMapping(value = "/roleAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> roleAuth() {
        log.info("roleAuth test...");
        return ResponseEntity.ok("test roleAuth.");
    }
}

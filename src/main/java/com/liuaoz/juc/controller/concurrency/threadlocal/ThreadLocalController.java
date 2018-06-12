package com.liuaoz.juc.controller.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试 SpringBoot 中如何定义filter和interceptor
 * ThreadLocal使用场景：数据库连接 Connection 对象,该对象是线程不安全的，使用时先获取一个对象方法ThreadLocal中，用完再移除
 * Created by matrix_stone on 2018/6/11.
 */
@Controller
@RequestMapping("/threadLocal")
@Slf4j
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        log.info("【test】测试方法主题部分");
        return RequestHolder.getId();
    }
}

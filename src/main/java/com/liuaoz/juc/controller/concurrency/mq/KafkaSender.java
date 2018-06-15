package com.liuaoz.juc.controller.concurrency.mq;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by matrix_stone on 2018/6/15.
 */
@Slf4j
@Component
public class KafkaSender {

    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(String msg) {
        Message message = new Message();
        message.setId(1);
        message.setMsg(TopicConstants.MESSAGE);
        message.setSendDate(new Date());

        log.info("send message:{}", message);

        kafkaTemplate.send(TopicConstants.TEST,gson.toJson(message));

    }
}

package com.liuaoz.juc.controller.highconcurrency.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by matrix_stone on 2018/6/15.
 */
@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {TopicConstants.TEST})
    public void receive(ConsumerRecord<?, ?> record) {
        log.info("receiver:{}", record);
    }
}

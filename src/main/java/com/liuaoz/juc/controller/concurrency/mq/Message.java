package com.liuaoz.juc.controller.concurrency.mq;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by matrix_stone on 2018/6/15.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Message {

    private Integer id;

    private String msg;

    private Date sendDate;
}

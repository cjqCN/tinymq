package com.github.cjqcn.tinymq.common.msg;

/**
 * @author: chenjinquan
 * @create: 2018-09-28 10:10
 **/
public class Heartbeat implements Msg {
    public static final Heartbeat instance = new Heartbeat();

    @Override
    public String toString() {
        return "ping pong";
    }
}

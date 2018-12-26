package com.github.cjqcn.tinymq.core.queue;

import com.github.cjqcn.tinymq.core.channel.ConsumeChannel;

import java.util.Queue;

public interface TinyQueue<T> extends Queue<T> {

    String topic();

    void addConsume(long openId, ConsumeChannel consumeChannel);

    void removeConsume(long openId);

}

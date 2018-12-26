package com.github.cjqcn.tinymq.core.queue;

import java.util.Map;
import java.util.Queue;

public interface TinyQueueHolder {

    Map<String, Queue> queues();

    void add(String topic, Queue queue);

    void delete(String topic);

}

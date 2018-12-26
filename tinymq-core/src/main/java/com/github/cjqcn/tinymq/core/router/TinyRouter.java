package com.github.cjqcn.tinymq.core.router;

import com.github.cjqcn.tinymq.core.queue.TinyQueue;

import java.util.Collection;

public interface TinyRouter {
    Collection<TinyQueue> route(RouteKey key);
}

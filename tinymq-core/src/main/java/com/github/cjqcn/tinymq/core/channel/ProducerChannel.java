package com.github.cjqcn.tinymq.core.channel;

import com.github.cjqcn.tinymq.core.router.RouteKey;

public interface ProducerChannel extends TinyChannel {

	RouteKey routeKey();
}

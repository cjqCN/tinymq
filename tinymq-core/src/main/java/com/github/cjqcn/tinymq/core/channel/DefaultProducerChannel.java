package com.github.cjqcn.tinymq.core.channel;

import com.github.cjqcn.tinymq.core.network.NetWorkContext;
import com.github.cjqcn.tinymq.core.queue.TinyQueue;
import com.github.cjqcn.tinymq.core.router.RouteKey;
import com.github.cjqcn.tinymq.core.router.TinyRouter;

import java.util.Collection;

/**
 * @author: chenjinquan
 * @create: 2018-10-11
 **/
public class DefaultProducerChannel extends AbstractTinyChannel implements ProducerChannel {

	RouteKey routeKey;

	TinyRouter tinyRouter;

	public DefaultProducerChannel(NetWorkContext netWorkContext, long openId, RouteKey routeKey,
								  TinyRouter tinyRouter) {
		super(netWorkContext, openId);
		this.routeKey = routeKey;
		this.tinyRouter = tinyRouter;
	}

	@Override
	public void receive(Object o) {
		Collection<TinyQueue> tinyQueues = tinyRouter.route(routeKey());
		tinyQueues.forEach(x -> {
			x.add(o);
		});
	}

	@Override
	public RouteKey routeKey() {
		return routeKey;
	}
}

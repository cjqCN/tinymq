package com.github.cjqcn.tinymq.core.network.netty;

import com.github.cjqcn.tinymq.common.Msg;
import com.github.cjqcn.tinymq.core.channel.TinyChannel;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-10-04 09:43
 **/
public class DefaultNetWorkContext extends AbstractNetWorkContext {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultNetWorkContext.class);

	public DefaultNetWorkContext(ChannelHandlerContext ctx) {
		online(ctx);
	}



	@Override
	public void receive(Msg msg) {

	}

	@Override
	public Map<Long, TinyChannel> channels() {
		return null;
	}
}

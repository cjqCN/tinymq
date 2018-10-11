package com.github.cjqcn.tinymq.core.network.netty.internal;


import com.github.cjqcn.tinymq.common.Msg;
import com.github.cjqcn.tinymq.common.req.InitReq;
import com.github.cjqcn.tinymq.core.network.netty.AbstractNetWorkContext;
import com.github.cjqcn.tinymq.core.network.netty.DefaultNetWorkContext;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-09-27 14:40
 **/
public class ServerContextHandler extends ServerHeartbeatHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ServerContextHandler.class);

	private AbstractNetWorkContext abstractNetWorkContext;

	@Override
	protected void close() {
		if (bindNetWorkContext()) {
			abstractNetWorkContext.outline();
		}
	}

	@Override
	protected void handleData0(ChannelHandlerContext ctx, Object msg) {
		if (!(msg instanceof Msg)) {
			return;
		}
		if (bindNetWorkContext()) {
			abstractNetWorkContext.receive((Msg) msg);
		} else {
			if (msg instanceof InitReq) {
				initNetWorkContext(ctx, (InitReq) msg);
			}
		}
	}

	private void initNetWorkContext(ChannelHandlerContext ctx, InitReq initReq) {
		LOG.info("initNetWorkContext:{}", initReq);
		AbstractNetWorkContext netWorkContext = new DefaultNetWorkContext(ctx);
		this.abstractNetWorkContext = netWorkContext;
	}

	private boolean bindNetWorkContext() {
		return abstractNetWorkContext != null;
	}

	@Override
	public boolean isSharable() {
		return false;
	}

}

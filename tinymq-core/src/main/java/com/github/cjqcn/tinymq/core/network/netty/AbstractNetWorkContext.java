package com.github.cjqcn.tinymq.core.network.netty;

import com.github.cjqcn.tinymq.common.Msg;
import com.github.cjqcn.tinymq.core.network.NetWorkContext;
import io.netty.channel.ChannelHandlerContext;

import java.net.SocketAddress;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-09-27 14:27
 **/
public abstract class AbstractNetWorkContext implements NetWorkContext<Msg> {

	private ChannelHandlerContext ctx;

	public void online(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}

	public synchronized void outline() {
		if (active()) {
			ctx.channel().close();
			ctx = null;
		}
	}

	@Override
	public synchronized SocketAddress addr() {
		if (active()) {
			return ctx.channel().remoteAddress();
		} else {
			return null;
		}
	}

	@Override
	public synchronized boolean active() {
		return ctx != null && ctx.channel().isOpen();
	}

	@Override
	public synchronized boolean send(Msg msg) throws Exception {
		if (active()) {
			ctx.writeAndFlush(msg);
		} else {
			throw new Exception("连接已断开");
		}
		return true;
	}

}

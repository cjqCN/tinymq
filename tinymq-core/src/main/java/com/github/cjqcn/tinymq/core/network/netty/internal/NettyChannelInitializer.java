package com.github.cjqcn.tinymq.core.network.netty.internal;

import com.github.cjqcn.tinymq.common.codec.KryoDecoder;
import com.github.cjqcn.tinymq.common.codec.KryoEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-09-25 14:39
 **/
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) {
		ChannelPipeline pipeline = ch.pipeline();
		ch.pipeline().addLast("decoder", new KryoDecoder());
		ch.pipeline().addLast("encoder", new KryoEncoder());
		pipeline.addLast(new IdleStateHandler(6, 0, 0));
		pipeline.addLast(new ServerContextHandler());
	}
}

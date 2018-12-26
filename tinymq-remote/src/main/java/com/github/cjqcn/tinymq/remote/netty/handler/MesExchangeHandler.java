package com.github.cjqcn.tinymq.remote.netty.handler;


import com.github.cjqcn.tinymq.common.msg.Msg;
import com.github.cjqcn.tinymq.core.network.MesExchange;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-10-08 09:44
 **/
public abstract class MesExchangeHandler extends ClientHeartbeatHandler implements MesExchange<Msg, Msg> {

    private static final Logger LOG = LoggerFactory.getLogger(MesExchangeHandler.class);

    final Channel channel;

    public MesExchangeHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Msg) {
            receive((Msg) msg);
        }
    }

    /**
     * 发送信息
     *
     * @param req
     */
    @Override
    public synchronized boolean send(Msg req) throws Exception {
        if (channel.isOpen()) {
            channel.writeAndFlush(req);
        } else {
            throw new Exception("连接已断开");
        }
        return true;
    }


    @Override
    public boolean isSharable() {
        return false;
    }
}

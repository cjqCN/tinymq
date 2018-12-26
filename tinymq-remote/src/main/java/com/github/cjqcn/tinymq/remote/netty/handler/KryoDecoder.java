package com.github.cjqcn.tinymq.remote.netty.handler;

import com.github.cjqcn.tinymq.common.codec.kryo.KryoSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description:
 * @author: chenjinquan
 * @create: 2018-09-28 10:07
 **/
public class KryoDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        Object obj = KryoSerializer.deserialize(in);
        out.add(obj);
    }
}
package com.github.cjqcn.tinymq.core.network;

import com.github.cjqcn.tinymq.common.MesExchange;
import com.github.cjqcn.tinymq.core.channel.TinyChannel;

import java.net.SocketAddress;
import java.util.Map;

public interface NetWorkContext<T> extends MesExchange<T, T> {

	Map<Long, TinyChannel> channels();

	SocketAddress addr();

	boolean active();

}

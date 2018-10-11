package com.github.cjqcn.tinymq.core.channel;

import com.github.cjqcn.tinymq.core.network.NetWorkContext;

/**
 * @author: chenjinquan
 * @create: 2018-10-11
 **/
public abstract class AbstractTinyChannel implements TinyChannel {

	private final NetWorkContext netWorkContext;
	private final long openId;

	public AbstractTinyChannel(NetWorkContext netWorkContext, long openId) {
		this.netWorkContext = netWorkContext;
		this.openId = openId;
	}

	@Override
	public boolean isOpen() {
		return netWorkContext.active();
	}

	@Override
	public boolean send(Object o) throws Exception {
		return netWorkContext.send(o);
	}

	@Override
	public long openId() {
		return openId;
	}
}

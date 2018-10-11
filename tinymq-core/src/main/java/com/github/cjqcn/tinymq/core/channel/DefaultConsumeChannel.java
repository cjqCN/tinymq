package com.github.cjqcn.tinymq.core.channel;

import com.github.cjqcn.tinymq.core.network.NetWorkContext;

/**
 * @author: chenjinquan
 * @create: 2018-10-11
 **/
public class DefaultConsumeChannel extends AbstractTinyChannel implements ConsumeChannel {

	private int type;
	private TinyChannel tinyChannel;


	public DefaultConsumeChannel(NetWorkContext netWorkContext, long openId, int type) {
		super(netWorkContext, openId);
		this.type = type;
	}


	@Override
	public int type() {
		return type;
	}

	@Override
	public TinyChannel channel() {
		return tinyChannel;
	}

	@Override
	public void receive(Object o) {

	}

}

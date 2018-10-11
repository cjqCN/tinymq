package com.github.cjqcn.tinymq.core.channel;

/**
 * @author: chenjinquan
 * @create: 2018-10-11
 **/
public interface ConsumeChannel extends TinyChannel {
	int type();
	TinyChannel channel();
}

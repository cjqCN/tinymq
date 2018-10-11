package com.github.cjqcn.tinymq.core.channel;


public interface ChannelContainer {

	void register(String openId, TinyChannel tinyChannel);

	void unregister(String openId);

	TinyChannel get(String openId);
}

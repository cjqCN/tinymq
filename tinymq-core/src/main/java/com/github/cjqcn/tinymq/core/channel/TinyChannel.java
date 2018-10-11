package com.github.cjqcn.tinymq.core.channel;

import com.github.cjqcn.tinymq.common.MesExchange;

public interface TinyChannel extends MesExchange {

	boolean isOpen();

	long openId();
}

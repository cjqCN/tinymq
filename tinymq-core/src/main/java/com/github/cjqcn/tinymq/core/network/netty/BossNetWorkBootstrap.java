package com.github.cjqcn.tinymq.core.network.netty;

import com.github.cjqcn.tinymq.core.network.NetWorkContext;

public interface BossNetWorkBootstrap {
	void register(NetWorkContext netWorkContext);
}

package com.github.cjqcn.tinymq.common;

public interface Sender<T> {

	/**
	 * 发送信息
	 *
	 * @param t
	 */
	boolean send(T t) throws Exception;
}

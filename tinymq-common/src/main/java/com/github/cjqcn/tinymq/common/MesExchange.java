package com.github.cjqcn.tinymq.common;

public interface MesExchange<T, O> {

	default void receive(T t) {
	}

	default boolean send(O o) throws Exception {
		return false;
	}
}

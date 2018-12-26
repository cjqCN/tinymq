package com.github.cjqcn.tinymq.core.network;

public interface MesExchange<T, O> {

    void receive(T t) throws Exception;

    boolean send(O o) throws Exception;
}

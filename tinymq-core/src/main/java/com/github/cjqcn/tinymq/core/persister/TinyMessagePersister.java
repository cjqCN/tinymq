package com.github.cjqcn.tinymq.core.persister;

public interface TinyMessagePersister<K, V> {

    void put(K key, V msg);

    void delete(K key);

    V get(K key);
}

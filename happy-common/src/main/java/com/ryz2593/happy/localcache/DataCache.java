package com.ryz2593.happy.localcache;

public interface DataCache<T> {
    public T getData();

    public void reload();

    public void remove();
}

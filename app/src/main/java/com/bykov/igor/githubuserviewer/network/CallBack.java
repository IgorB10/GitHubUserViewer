package com.bykov.igor.githubuserviewer.network;

public interface CallBack<T> {

    void onFinish(T model);

    void onError(String errorMessage);
}

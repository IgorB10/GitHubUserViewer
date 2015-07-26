package com.bykov.igor.githubuserviewer.mvp.presenter.abstractPresenters;

import com.bykov.igor.githubuserviewer.mvp.view.View;

public abstract class Presenter<T extends View> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    abstract public void initialize();

    abstract public void resume();

    abstract public void pause();

    abstract public void destroy();

}

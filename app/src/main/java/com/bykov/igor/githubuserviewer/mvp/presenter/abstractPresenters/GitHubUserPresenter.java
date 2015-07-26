package com.bykov.igor.githubuserviewer.mvp.presenter.abstractPresenters;

import com.bykov.igor.githubuserviewer.mvp.presenter.abstractPresenters.Presenter;
import com.bykov.igor.githubuserviewer.mvp.view.GitHubUsersView;

public abstract class GitHubUserPresenter extends Presenter<GitHubUsersView> {

    public abstract void onUsersReceived(String page, String chunk);
}

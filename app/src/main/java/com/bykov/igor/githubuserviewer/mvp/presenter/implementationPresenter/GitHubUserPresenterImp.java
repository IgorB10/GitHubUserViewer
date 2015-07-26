package com.bykov.igor.githubuserviewer.mvp.presenter.implementationPresenter;

import com.bykov.igor.githubuserviewer.mvp.presenter.abstractPresenters.GitHubUserPresenter;
import com.bykov.igor.githubuserviewer.mvp.presenter.abstractPresenters.Presenter;
import com.bykov.igor.githubuserviewer.mvp.view.GitHubUsersView;
import com.bykov.igor.githubuserviewer.network.CallBack;
import com.bykov.igor.githubuserviewer.network.api.users.GitHubUserApi;
import com.bykov.igor.githubuserviewer.network.model.User;

import java.util.List;

import javax.inject.Inject;

public class GitHubUserPresenterImp extends GitHubUserPresenter {

    private GitHubUserApi gitHubUserApi;

    @Inject
    public GitHubUserPresenterImp(GitHubUserApi api){
        gitHubUserApi = api;
    }

    @Override
    public void onUsersReceived(String page, String chunk) {
        loadUser(page, chunk);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private void loadUser(final String page, final String chunk){
        gitHubUserApi.getUsers(page, chunk, new CallBack<List<User>>() {
            @Override
            public void onFinish(List<User> users) {
                view.renderUsers(users);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }
}

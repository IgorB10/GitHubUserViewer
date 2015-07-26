package com.bykov.igor.githubuserviewer.di.modules;

import com.bykov.igor.githubuserviewer.BuildConfig;
import com.bykov.igor.githubuserviewer.mvp.presenter.implementationPresenter.GitHubUserPresenterImp;
import com.bykov.igor.githubuserviewer.network.api.users.GitHubUserApi;
import com.bykov.igor.githubuserviewer.network.api.users.MockGitHubApi;
import com.bykov.igor.githubuserviewer.network.api.users.RetrofitGitHubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GitHubUsersModule {

    @Provides
    @Singleton
    protected GitHubUserApi provideGitHubUserApi() {
//        return BuildConfig.DEBUG ? new MockGitHubApi() : new RetrofitGitHubApi();
        return new RetrofitGitHubApi();
    }

    @Provides
    @Singleton
    protected GitHubUserPresenterImp provideGitHubUserPresenter(GitHubUserApi api) {
        return new GitHubUserPresenterImp(api);
    }

}

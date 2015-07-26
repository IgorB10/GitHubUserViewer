package com.bykov.igor.githubuserviewer.network.api.users;

import com.bykov.igor.githubuserviewer.network.CallBack;
import com.bykov.igor.githubuserviewer.network.api.GitHubApi;
import com.bykov.igor.githubuserviewer.network.model.User;

import java.util.List;

public abstract class GitHubUserApi implements GitHubApi {

    public abstract void getUsers(String page, String chunk, CallBack<List<User>> callback);
}

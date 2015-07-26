package com.bykov.igor.githubuserviewer.mvp.view;

import com.bykov.igor.githubuserviewer.network.model.User;

import java.util.List;

public interface GitHubUsersView extends View {

    void renderUsers(List<User> users);
}

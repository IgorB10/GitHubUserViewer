package com.bykov.igor.githubuserviewer.di.component;

import com.bykov.igor.githubuserviewer.ui.activity.MainActivity;
import com.bykov.igor.githubuserviewer.ui.fragment.GitHubUsersListFragment;

public interface ApplicationGraph {

    void inject(MainActivity mainActivity);


}

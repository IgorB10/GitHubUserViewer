package com.bykov.igor.githubuserviewer.di.component;

import android.app.Application;

import com.bykov.igor.githubuserviewer.di.modules.GitHubUsersModule;
import com.bykov.igor.githubuserviewer.di.modules.MainModule;
import com.bykov.igor.githubuserviewer.ui.activity.MainActivity;
import com.bykov.igor.githubuserviewer.ui.fragment.BaseListFragment;
import com.bykov.igor.githubuserviewer.ui.fragment.GitHubUsersListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {GitHubUsersModule.class})
public interface GitHubUsersComponent {

    void inject(GitHubUsersListFragment fragment);


    final class Initializer {
        private Initializer() {
        }

        public static GitHubUsersComponent init() {
            return DaggerGitHubUsersComponent.builder()
                    .gitHubUsersModule(new GitHubUsersModule())
                    .build();
        }
    }
}

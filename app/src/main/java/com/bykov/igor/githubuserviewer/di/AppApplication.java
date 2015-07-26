package com.bykov.igor.githubuserviewer.di;

import android.app.Application;
import android.content.Context;

import com.bykov.igor.githubuserviewer.di.component.AppComponent;
import com.bykov.igor.githubuserviewer.di.component.GitHubUsersComponent;

public class AppApplication extends Application {

    private static Application application;
    private static AppComponent graph;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        buildComponentAndInject();
    }

    public static AppComponent component() {
        return graph;
    }

    public static Application getApplication() {
        return application;
    }

    public static void buildComponentAndInject() {
        graph = AppComponent.Initializer.init(application);
    }
}

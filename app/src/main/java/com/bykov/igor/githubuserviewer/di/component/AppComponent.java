package com.bykov.igor.githubuserviewer.di.component;

import android.app.Application;

import com.bykov.igor.githubuserviewer.di.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface AppComponent extends ApplicationGraph {

    final class Initializer {
        private Initializer() {
        }

        public static AppComponent init(Application app) {
            return DaggerAppComponent.builder()
                    .mainModule(new MainModule(app))
                    .build();
        }
    }

}

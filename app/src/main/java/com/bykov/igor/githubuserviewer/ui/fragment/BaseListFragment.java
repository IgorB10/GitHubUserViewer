package com.bykov.igor.githubuserviewer.ui.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseListFragment extends ListFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    abstract void injectDependencies();

    private void injectViews(View view) {
        ButterKnife.bind(this, view);
    }
}

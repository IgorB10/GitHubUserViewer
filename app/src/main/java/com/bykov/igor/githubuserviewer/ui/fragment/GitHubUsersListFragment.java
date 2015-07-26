package com.bykov.igor.githubuserviewer.ui.fragment;

import android.app.ListFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bykov.igor.githubuserviewer.R;
import com.bykov.igor.githubuserviewer.di.component.GitHubUsersComponent;
import com.bykov.igor.githubuserviewer.mvp.presenter.implementationPresenter.GitHubUserPresenterImp;
import com.bykov.igor.githubuserviewer.mvp.view.GitHubUsersView;
import com.bykov.igor.githubuserviewer.network.api.users.RetrofitGitHubApi;
import com.bykov.igor.githubuserviewer.network.model.User;
import com.bykov.igor.githubuserviewer.ui.adapter.GitHubUserAdapter;
import com.bykov.igor.githubuserviewer.ui.adapter.InfiniteListViewPaging;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GitHubUsersListFragment extends BaseListFragment implements GitHubUsersView {

    private InfiniteListViewPaging mListPaging;
    private ArrayList<User> users;
    private GitHubUserAdapter gitHubUserAdapter;

    @Inject
    GitHubUserPresenterImp gitHubUserPresenterImp;

    private static final int CHUNK_SIZE = 50;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gitHubUserPresenterImp.setView(this);
        mListPaging = new InfiniteListViewPaging(getActivity(), getListView()) {
            @Override
            public void loadMore() {
                loadMoreUsers();
            }
        };
        getListView().setOnScrollListener(mListPaging);
        users = new ArrayList<>();
        gitHubUserAdapter = new GitHubUserAdapter(getActivity(), users);
        setListAdapter(gitHubUserAdapter);
        loadMoreUsers();
    }

    @Override
    void injectDependencies() {
        GitHubUsersComponent.Initializer.init().inject(this);
    }

    @Override
    public void renderUsers(List<User> user) {
        users.addAll(user);
        gitHubUserAdapter.notifyDataSetChanged();
        mListPaging.hasFinishedLoading();
        mListPaging.setCanLoadMore(canLoadMore(getListAdapter().getCount()));
    }

    private void loadMoreUsers(){
        gitHubUserPresenterImp.onUsersReceived(Integer.toString(getListAdapter().getCount()), Integer.toString(CHUNK_SIZE));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private boolean canLoadMore(int count) {
        return count >= CHUNK_SIZE;
    }

}

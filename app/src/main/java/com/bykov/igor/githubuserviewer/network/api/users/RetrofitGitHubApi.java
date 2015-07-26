package com.bykov.igor.githubuserviewer.network.api.users;

import com.bykov.igor.githubuserviewer.network.CallBack;
import com.bykov.igor.githubuserviewer.network.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitGitHubApi extends GitHubUserApi {

    RestAdapter restAdapter = new RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint(BASE_URL)
            .build();

    GitHubUserService service = restAdapter.create(GitHubUserService.class);

    @Override
    public void getUsers(String page, String chunk, final CallBack<List<User>> callback) {
       service.listUsers(page, chunk, new Callback<List<User>>() {
           @Override
           public void success(List<User> users, Response response) {
               callback.onFinish(users);
           }

           @Override
           public void failure(RetrofitError error) {
                callback.onError(error.getMessage());
           }
       });
    }
}

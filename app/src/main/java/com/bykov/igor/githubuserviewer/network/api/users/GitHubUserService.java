package com.bykov.igor.githubuserviewer.network.api.users;

import com.bykov.igor.githubuserviewer.network.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GitHubUserService {

    @GET("/users")
    void listUsers(@Query("since") String source, @Query("per_page") String chunk, Callback<List<User>> cb);
}

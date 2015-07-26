package com.bykov.igor.githubuserviewer.network.api.users;

import com.bykov.igor.githubuserviewer.di.AppApplication;
import com.bykov.igor.githubuserviewer.network.CallBack;
import com.bykov.igor.githubuserviewer.network.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MockGitHubApi extends GitHubUserApi {

    @Override
    public void getUsers(String page, String chunk, CallBack<List<User>> callback) {
        List<User> users = new Gson().fromJson(loadUsers(), new TypeToken<List<User>>(){}.getType());
        callback.onFinish(users);
    }

    private String loadUsers() {
        String json = null;
        try {
            InputStream is = AppApplication.getApplication().getAssets().open("users/github_users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

package com.bykov.igor.githubuserviewer.ui.adapter;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bykov.igor.githubuserviewer.R;
import com.bykov.igor.githubuserviewer.network.model.User;
import com.bykov.igor.githubuserviewer.ui.dialog.ImageProfileDialogFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GitHubUserAdapter extends ArrayAdapter<User> {

    public GitHubUserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.git_user_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        final User user = getItem(position);
        Picasso.with(getContext()).load(user.getAvatar_url()).into(viewHolder.userThumbnail);
        viewHolder.userThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = ImageProfileDialogFragment.newInstance(user.getAvatar_url());
                newFragment.show(((Activity)getContext()).getFragmentManager(), "dialog");
            }
        });
        viewHolder.userLogin.setText(user.getLogin());
        viewHolder.userLink.setText(user.getHtml_url());
        return convertView;
    }

    public static class ViewHolder {

        @Bind(R.id.user_thumbnail) ImageView userThumbnail;
        @Bind(R.id.user_login) TextView userLogin;
        @Bind(R.id.user_link) TextView userLink;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
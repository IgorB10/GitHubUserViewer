package com.bykov.igor.githubuserviewer.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bykov.igor.githubuserviewer.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageProfileDialogFragment extends DialogFragment {

    private static final String EXTRA_URL = "extra_url";

    public static ImageProfileDialogFragment newInstance(String url) {
        ImageProfileDialogFragment f = new ImageProfileDialogFragment();
        f.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
        Bundle args = new Bundle();
        args.putString(EXTRA_URL, url);
        f.setArguments(args);
        return f;
    }

    @Bind(R.id.image_profile_iv)
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_profile, container, false);
        getDialog().setCanceledOnTouchOutside(true);
        ButterKnife.bind(this, view);
        String url = getArguments().getString(EXTRA_URL);
        Picasso.with(getActivity()).load(url).into(imageView);
        return view;
    }

}

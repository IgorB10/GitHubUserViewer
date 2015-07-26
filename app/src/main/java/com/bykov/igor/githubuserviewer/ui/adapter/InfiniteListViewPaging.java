package com.bykov.igor.githubuserviewer.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.bykov.igor.githubuserviewer.R;

public abstract class InfiniteListViewPaging implements AbsListView.OnScrollListener {

    private static final String TAG = InfiniteListViewPaging.class.getName();
    public ListView mListView;
    public View mFooterView;
    private boolean mCanLoadMore;
    private boolean mIsLoading;

    /**
     * Should be created before setting the adapter on the {@code listView} as this sets the
     * {@link ListView#addFooterView(View)} on it.
     * @param context
     * @param listView
     */
    public InfiniteListViewPaging(Context context, ListView listView) {
        mFooterView = View.inflate(context, R.layout.footer_list_view, null);
        mListView = listView;
        listView.addFooterView(mFooterView, null, false);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                         int totalItemCount) {
        boolean lessThanOneScreenLeftToScrollDown = (totalItemCount - 2 * visibleItemCount) <= firstVisibleItem;
        if (mCanLoadMore && !mIsLoading && lessThanOneScreenLeftToScrollDown) {
            Log.d(TAG, "Load Next Page!");
            mIsLoading = true;
            loadMore();
        }
    }

    public void setCanLoadMore(boolean canLoadMore) {
        mCanLoadMore = canLoadMore;
        mFooterView.setVisibility(canLoadMore ? View.VISIBLE : View.GONE);
    }

    public abstract void loadMore();

    public void hasFinishedLoading() {
        mIsLoading = false;
    }
}

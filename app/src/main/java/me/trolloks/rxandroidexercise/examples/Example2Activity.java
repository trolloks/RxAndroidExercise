package me.trolloks.rxandroidexercise.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import me.trolloks.rxandroidexercise.R;
import me.trolloks.rxandroidexercise.utils.RestClient;
import me.trolloks.rxandroidexercise.utils.SimpleStringAdapter;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rikus on 2017/06/15.
 */

public class Example2Activity extends AppCompatActivity {

    private Subscription mTvShowSubscription;
    private RecyclerView mTvShowListView;
    private ProgressBar mProgressbar;
    private SimpleStringAdapter mSimpleStringAdapter;
    private RestClient mRestClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestClient = new RestClient(this);
        configureLayout();
        createObservable();
    }

    private void createObservable() {
        // fromCallable does NOT run on the UI thread
        Observable<List<String>> tvShowObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return mRestClient.getFavoriteTvShows();
            }
        });

        mTvShowSubscription = tvShowObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    new Observer<List<String>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<String> tvShows) {
                            displayTvShows(tvShows);
                        }
                    }
                );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mTvShowSubscription != null && !mTvShowSubscription.isUnsubscribed()) {
            mTvShowSubscription.unsubscribe();
        }
    }

    private void configureLayout() {
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setContentView(R.layout.activity_example2);
        setTitle("Example 2");
        mProgressbar = (ProgressBar) findViewById(R.id.loader);
        mTvShowListView = (RecyclerView) findViewById(R.id.tv_show_list);
        mTvShowListView.setLayoutManager(new LinearLayoutManager(this));
        mSimpleStringAdapter = new SimpleStringAdapter(this);
        mTvShowListView.setAdapter(mSimpleStringAdapter);
    }

    private void displayTvShows(List<String> tvShows) {
        mSimpleStringAdapter.setStrings(tvShows);
        mProgressbar.setVisibility(View.GONE);
        mTvShowListView.setVisibility(View.VISIBLE);
    }

    // OVERRIDES

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

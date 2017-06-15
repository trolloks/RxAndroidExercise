package me.trolloks.rxandroidexercise.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.trolloks.rxandroidexercise.R;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Created by rikus on 2017/06/15.
 */

public class Example5Activity extends AppCompatActivity {

    private TextView mValueDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureLayout();

        // transforming 4 from an int to a string
        Single.just(4).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return String.valueOf(integer);
            }
        }).subscribe(new SingleSubscriber<String>() {
            @Override
            public void onSuccess(String value) {
                mValueDisplay.setText(value);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }


    private void configureLayout() {
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setContentView(R.layout.activity_example5);
        setTitle("Map");
        mValueDisplay = (TextView) findViewById(R.id.value_display);
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

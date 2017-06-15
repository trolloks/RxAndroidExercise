package me.trolloks.rxandroidexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.trolloks.rxandroidexercise.examples.Example1Activity;

/**
 * Created by rikus on 2017/06/15.
 */

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureLayout();
    }

    private void configureLayout() {
        setContentView(R.layout.activity_main);

        findViewById(R.id.example1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example1Activity.class);
                startActivity(intent);
            }
        });
    }


}

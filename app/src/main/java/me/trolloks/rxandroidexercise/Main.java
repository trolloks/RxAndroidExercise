package me.trolloks.rxandroidexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.trolloks.rxandroidexercise.examples.Example1Activity;
import me.trolloks.rxandroidexercise.examples.Example2Activity;
import me.trolloks.rxandroidexercise.examples.Example3Activity;
import me.trolloks.rxandroidexercise.examples.Example4Activity;
import me.trolloks.rxandroidexercise.examples.Example5Activity;
import me.trolloks.rxandroidexercise.examples.Example6Activity;

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

        findViewById(R.id.example2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example2Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.example3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example3Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.example4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example4Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.example5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example5Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.example6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Example6Activity.class);
                startActivity(intent);
            }
        });
    }


}

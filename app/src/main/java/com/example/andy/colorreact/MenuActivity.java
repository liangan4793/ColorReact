package com.example.andy.colorreact;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

public class MenuActivity extends AppCompatActivity {

    private ImageView mainMenuIcon;
    private Color colorGenerator;
    private boolean isActive = false;
    private int[] colors = new int[] {Color.BLUE, Color.BLACK, Color.GREEN, Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    private void generateRandomColor() {

    }


    @Override
    protected void onStart() {
        super.onStart();
        isActive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }
}

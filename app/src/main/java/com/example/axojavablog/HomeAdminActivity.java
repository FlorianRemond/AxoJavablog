package com.example.axojavablog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class HomeAdminActivity extends AppCompatActivity {
    private static int SPLAHSCREEN_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        // Après 2000 ms (SPLASHSCREEN_TIMEOUT) on passe à l'activité principale :
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HomeAdminActivity.this, GestionAdminActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLAHSCREEN_TIMEOUT);
    }
}

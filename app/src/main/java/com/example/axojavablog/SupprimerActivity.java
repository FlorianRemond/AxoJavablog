package com.example.axojavablog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SupprimerActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lvArticle;
    private Button btnSupprimerList;
    private DataBaseManager dbm;
    private List<Article> ListArt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        dbm = new DataBaseManager(this);
        ListArt = new ArrayList<>();
        ListArt = dbm.getAllArticle();
        // refresh();
        initButton();
        listenerButton();

        lvArticle.setAdapter(new AdapterArticle(this, dbm.getAllArticle()));
        Log.i("Liste Article", "" + dbm.getAllArticle());
    }

    public void initButton() {
        btnSupprimerList = findViewById(R.id.btnSupprimerList);
        lvArticle = findViewById(R.id.lvArticle);
    }

    public void listenerButton() {
        btnSupprimerList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(lvArticle)) {
            Toast.makeText(this, "lvArt", Toast.LENGTH_LONG).show();
        }
        if (view.equals(btnSupprimerList)) {
            Toast.makeText(this, "btnsupp", Toast.LENGTH_LONG).show();
        }
    }


}







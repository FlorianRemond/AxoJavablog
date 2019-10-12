package com.example.axojavablog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GestionAdminActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAjouterArticle, btnEditerArticle, btnSupprimerArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_admin);
        initButton();
        listnerButton();

    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnEditerArticle)) {
            Intent Edition = new Intent(GestionAdminActivity.this, ValidationActivity.class);
            startActivity(Edition);
        }
        if (view.equals(btnAjouterArticle)) {
            Intent Ajout = new Intent(GestionAdminActivity.this, AjoutActivity.class);
            startActivity(Ajout);
        }
        if (view.equals(btnSupprimerArticle)) {
            Intent Supprimer = new Intent(GestionAdminActivity.this, SupprimerActivity.class);
            startActivity(Supprimer);

        }

    }


    public void initButton() {
        btnAjouterArticle = (findViewById(R.id.btnAjouterArticle));
        btnEditerArticle = (findViewById(R.id.btnEditerArticle));
        btnSupprimerArticle = (findViewById(R.id.btnSupprimerArticle));
    }

    public void listnerButton() {
        btnAjouterArticle.setOnClickListener(this);
        btnEditerArticle.setOnClickListener(this);
        btnSupprimerArticle.setOnClickListener(this);
    }
}

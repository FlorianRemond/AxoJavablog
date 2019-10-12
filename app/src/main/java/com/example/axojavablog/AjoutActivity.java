package com.example.axojavablog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editInsTitreArticle, editInsContenuArticle;
    private Button insBtnImg, insBtnPublier;
    private DataBaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        initButton();
        listenerButton();
        dbm = new DataBaseManager(this);

    }

    public void initButton() {
        insBtnImg = findViewById(R.id.insBtnImg);
        insBtnPublier = findViewById(R.id.insBtnPublier);
        editInsTitreArticle = findViewById(R.id.editInsTitreArticle);
        editInsContenuArticle = findViewById(R.id.editInsContenuArticle);
    }

    public void listenerButton() {
        insBtnImg.setOnClickListener(this);
        insBtnPublier.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(insBtnImg)) {

        }
        if (view.equals(insBtnPublier)) {
            String titre = editInsTitreArticle.getText().toString();
            String contenu = editInsContenuArticle.getText().toString();

            //  dbm.insertArticle(titre,contenu,);
        }
    }
}

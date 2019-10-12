package com.example.axojavablog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class ValidationActivity extends AppCompatActivity implements View.OnClickListener {
    private DataBaseManager dbm;
    private Button BtnPrecPublication, BtnSuivPublication, btnPublication;
    private EditText editTitre, editArticle, idValidationArticle;
    private ImageView imgArticle;
    private ListView ListCategory;
    private List<Article> listeArt;
    //private TextView idValidationArticle;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        this.index = 0;

        //fonction initialisation des bouttons
        initButtonTxt();
        //fonction ecoute des boutons
        initButtonListener();
        //fonction d'affchage de l'article
        dbm = new DataBaseManager(this);
        this.listeArt = dbm.getAllArticle();
        displayArticle(index);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(BtnPrecPublication)) {
            if (index >= 0 && index < listeArt.size()) {
                if (index > 0) {
                    index--;
                }
                this.displayArticle(index);
            } else {
                Toast.makeText(this, "---->", Toast.LENGTH_SHORT).show();
            }
        }
        if (view.equals(BtnSuivPublication)) {
            if (index >= 0 && index < listeArt.size()) {
                if (index < listeArt.size() - 1) {
                    index++;
                } else {
                    Toast.makeText(this, "<----", Toast.LENGTH_SHORT).show();
                }
                this.displayArticle(index);
            }
        }
        if (view.equals(btnPublication)) {
            int idA = Integer.parseInt(idValidationArticle.getText().toString());
            String titre = editTitre.getText().toString().trim();
            String contenu = editArticle.getText().toString().trim();
            dbm.updateArticle(idA, titre, contenu);

            Toast.makeText(this, "BtnPublication" + idA, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "BtnPublication" + imgArticle, Toast.LENGTH_SHORT).show();
        }

    }

    public void initButtonTxt() {
        BtnPrecPublication = findViewById(R.id.BtnPrecPublication);
        BtnSuivPublication = findViewById(R.id.BtnSuivPublication);
        btnPublication = findViewById(R.id.btnPublication);
        editTitre = findViewById(R.id.editTitre);
        editArticle = findViewById(R.id.editArticle);
        imgArticle = findViewById(R.id.imgArticle);
        idValidationArticle = findViewById(R.id.idValidationArticle);
    }

    public void initButtonListener() {
        BtnPrecPublication.setOnClickListener(this);
        BtnSuivPublication.setOnClickListener(this);
        btnPublication.setOnClickListener(this);
    }

    public void displayArticle(int idArticle) {
        Article article = this.listeArt.get(idArticle);
        editTitre.setText(article.getTitreArticle());
        editArticle.setText(article.getContentArticle());
        idValidationArticle.setText(Integer.toString(article.getIdArticle()));
        imgArticle.setImageResource(Integer.parseInt(article.getImageArticle()));
    }
}

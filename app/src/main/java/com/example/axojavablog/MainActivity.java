package com.example.axojavablog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DataBaseManager dbm;
    private Button btnValider, btnReset;
    private EditText txtLogin, txtMotDePasse;
    private TextView txtRegister;
    private String chaine;
    private ListView lvArticle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fonction initialisation des bouttons
        initButton();
        //fonction ecoute des boutons
        initButtonListener();
        dbm = new DataBaseManager(this);


        //Ajout en base
        //dbm.insertCategory("art","musique, concert, expo  ");
        //dbm.insertArticle("Test image  ","contenu pour test image2",Integer.toString(R.drawable.imagetest));
        //dbm.insertArticle("Article de qualité  ","contenu pour test sur article",Integer.toString(R.drawable.construction));
        //dbm.insertUser("sympa@gmailcom","nomUser1","motdepasse");
        //dbm.insertAdmin("ladmin","passpass");

        //Suppression en base
        // dbm.deleteCategory(1);
        //dbm.deleteArticle(2);
        //dbm.deleteArticle(3);
        //dbm.deleteUser(1);

        //modification en base
        // dbm.updateCategory(2,"Sport","natation et foot");
        // dbm.updateArticle(2,"test update","contenu test update","image test update");
        // dbm.updateUser(2,"testupdate@gmail.com", "testtoto","toto");

        //getall de la base
        //dbm.getAllCategory();
        //dbm.getAllArticle();
        //dbm.getAllUser();

        //getone
        //User user =  dbm.getOneUser(2)
        // Log.i("DB", "getOne User Ok : " + user );
        //  Article article = dbm.getOneArticle(3);
        //  Log.i("DB", "getOne Article Ok : " +  article);
        //  Category category= dbm.getOneCategory(3);
        // Log.i("DB","getOne Categorie ok : " + category);
    }


    @Override
    public void onClick(View view) {

       /* if (view.equals(btnValider)) {
            Intent Read = new Intent(MainActivity.this, ReadActivity.class);
            startActivity(Read);

            Toast.makeText(this, "btn valider", Toast.LENGTH_SHORT).show();
        }*/

        if (view.equals(btnReset)) {
            chaine = "";
            txtLogin.setText(chaine);
            txtMotDePasse.setText(chaine);
            Toast.makeText(this, "btn reset", Toast.LENGTH_SHORT).show();
        }

    }


    public void initButton() {
        btnValider = findViewById(R.id.btnValider);
        btnReset = findViewById(R.id.btnReset);
        txtLogin = findViewById(R.id.txtLogin);
        txtMotDePasse = findViewById(R.id.txtMotDePasse);
        txtRegister = findViewById(R.id.txtRegister);
    }

    public void initButtonListener() {
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameUser = txtLogin.getText().toString().trim();
                String passUser = txtMotDePasse.getText().toString().trim();


                boolean adm = dbm.checkAdmin(nameUser, passUser);
                boolean res = dbm.checkUser(nameUser, passUser);

                if (adm) {
                    Intent HomeAdmin = new Intent(MainActivity.this, HomeAdminActivity.class);
                    startActivity(HomeAdmin);

                } else if (res) {
                    Intent HomePage = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez vous enregistrer", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnReset.setOnClickListener(this);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }


}

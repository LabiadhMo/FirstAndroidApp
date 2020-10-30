package com.example.tp1gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Ajout extends AppCompatActivity implements View.OnClickListener {
    EditText ednom,edprenom,ednumero;
    Button btnval,btnqte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        ednom=findViewById(R.id.Ed_nom_Ajout);
        edprenom=findViewById(R.id.Ed_prenom_Ajout);
        ednumero=findViewById(R.id.Ed_phone_Ajout);
        btnval=findViewById(R.id.btnVal_ajout);
        btnqte=findViewById(R.id.btnqte_ajout);

        btnval.setOnClickListener(this);
        btnqte.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnqte){
        Ajout.this.finish();
        }
        if (v==btnval){
            String nom=ednom.getText().toString();
            String prenom=edprenom.getText().toString();
            String numero=ednumero.getText().toString();

            Contact contact=new Contact(nom,prenom,numero);
            Home.contacts.add(contact);
            ednom.setText("");
            edprenom.setText("");
            ednumero.setText("");
            Intent i = new Intent(Ajout.this,Affichage.class);
            startActivity(i);
        }
    }
}

package com.example.tp1gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edition extends AppCompatActivity implements View.OnClickListener {
    EditText ednom,edprenom,ednumero;
    Button btnval,btnqte;
    int position;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);
        ednom=findViewById(R.id.Ed_nom_edit);
        edprenom=findViewById(R.id.Ed_prenom_edit);
        ednumero=findViewById(R.id.Ed_phone_edit);
        btnval=findViewById(R.id.btnVal_edit);
        btnqte=findViewById(R.id.btnqte_edit);
        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        position= b.getInt("ID");
        contact=Home.contacts.get(position);
        ednom.setText(contact.getNom());
        edprenom.setText(contact.getPrenom());
        ednumero.setText(contact.getNumero());
        btnval.setOnClickListener(this);
        btnqte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnqte){
            Edition.this.finish();
        }
        if (v==btnval){
            String nom=ednom.getText().toString();
            String prenom=edprenom.getText().toString();
            String numero=ednumero.getText().toString();

            contact.setNom(nom);
            contact.setPrenom(prenom);
            contact.setNumero(numero);

            Home.contacts.set(position,contact);

            Edition.this.finish();

        }
    }
}

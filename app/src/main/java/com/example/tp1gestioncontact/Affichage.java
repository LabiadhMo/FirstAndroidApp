package com.example.tp1gestioncontact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity implements AdapterView.OnItemClickListener , DialogInterface.OnClickListener {
    ListView listv;
    EditText edrech;
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        listv=findViewById(R.id.lv_affichage);
        edrech=findViewById(R.id.ed_rech_affichage);

        edrech.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Contact> le=new ArrayList<>();
                for(Contact current : Home.contacts) {
                    current.nom.indexOf(s.toString());
                    if (current.nom.indexOf(s.toString())>=0){
                        le.add(current);
                    }
                }
                MonAdapter adapter=new MonAdapter(Affichage.this,le);
                listv.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
       /* ArrayAdapter adapter=new ArrayAdapter(Affichage.this,
                android.R.layout.simple_list_item_1,
                Home.contacts);
        */
       MonAdapter adapter=new MonAdapter(Affichage.this,Home.contacts);
       listv.setAdapter(adapter);
        listv.setOnItemClickListener(this);
        // textchangelistener ..
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice=position;
        AlertDialog.Builder alert=new AlertDialog.Builder(Affichage.this);
        alert.setTitle("Action!");
        alert.setMessage("Choisir une action");
        alert.setPositiveButton("Supprimer",this);
        alert.setNegativeButton("Modifier",this);
        alert.setNeutralButton("Supprimer tous",this);
        alert.show();


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==dialog.BUTTON_POSITIVE){
            Home.contacts.remove(indice);

        }
        if(which==dialog.BUTTON_NEGATIVE){
            // to do !!!!!! edit with a form
            Intent i = new Intent(Affichage.this,Edition.class);
            i.putExtra("ID",indice);
            startActivity(i);
        }
        if(which==dialog.BUTTON_NEUTRAL){
            Home.contacts.clear();
            listv.invalidateViews();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"started",Toast.LENGTH_SHORT );
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"stop",Toast.LENGTH_SHORT );
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"destroy",Toast.LENGTH_SHORT );
        super.onDestroy();
    }
}

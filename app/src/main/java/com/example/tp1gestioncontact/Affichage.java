package com.example.tp1gestioncontact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

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


        ArrayAdapter adapter=new ArrayAdapter(Affichage.this,
                android.R.layout.simple_list_item_1,
                Home.contacts);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(this);
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
}

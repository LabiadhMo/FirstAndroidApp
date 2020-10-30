package com.example.tp1gestioncontact;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaration des composantes
    EditText edname_auth,edpass_auth;
    private Button btnval;
    private Button btnexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edname_auth=findViewById(R.id.edname_auth);
        edpass_auth=findViewById(R.id.edpass_auth);
        btnval=findViewById(R.id.btnval_auth);
        btnexit=findViewById(R.id.btnexit_auth);



        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edname_auth.getText().toString();
                String password=edpass_auth.getText().toString();
                if(name.equalsIgnoreCase("test")&& password.equalsIgnoreCase("000")){

                    Intent i = new Intent(MainActivity.this,Home.class);
                    i.putExtra("userName",name);
                    startActivity(i);

                }
                else{
                    Toast.makeText(MainActivity.this, "Error values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}

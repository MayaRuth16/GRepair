package com.myfirstapp.maya.grepair;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myfirstapp.maya.grepair.R;

public class InscriptionActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private TextInputEditText mName, mEmail, mNumber, mPwd;
    private Button mbtnInscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        databaseHelper = new DatabaseHelper(getApplicationContext());

        mName = findViewById(R.id.txtNom);
        mEmail = findViewById(R.id.txtEmail);
        mNumber = findViewById(R.id.txtTelephone);
        mPwd = findViewById(R.id.txtMotDePasse);
        mbtnInscription = findViewById(R.id.btnInscription);
        mbtnInscription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mbtnInscription_onClick(v);
            }
        });
    }
    public void mbtnInscription_onClick(View view){
        try{
            databaseHelper = new DatabaseHelper(getApplicationContext());
            User user = new User();
            user.setName(mName.getText().toString());
            user.setEmail(mEmail.getText().toString());
            user.setNumber(Integer.parseInt(mNumber.getText().toString()));
            user.setPasword(mPwd.getText().toString());
            databaseHelper.addUser(user);
            Intent intent = new Intent(InscriptionActivity.this, ConnexionActivity.class);
            startActivity(intent);
        }catch(Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("error");
            builder.setMessage("can't create");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }


}

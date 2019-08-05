package com.myfirstapp.maya.grepair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class BienvenueActivity extends AppCompatActivity {

    LinearLayout menus, textsplash;
    Animation frombottom;
    Button mbtnpasser, mbtninscrire, mbtnconnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenue);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        menus = (LinearLayout) findViewById(R.id.menus);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        mbtnpasser = (Button) findViewById(R.id.btnpasser);
        mbtninscrire = (Button) findViewById(R.id.btninscrire);
        mbtnconnecter = (Button) findViewById(R.id.btnconnecter);


        textsplash.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        mbtnpasser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent (BienvenueActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mbtninscrire.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent (BienvenueActivity.this, InscriptionActivity.class);
                startActivity(i);
            }
        });
        mbtnconnecter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent (BienvenueActivity.this, ConnexionActivity.class);
                startActivity(i);
            }
        });

    }
}

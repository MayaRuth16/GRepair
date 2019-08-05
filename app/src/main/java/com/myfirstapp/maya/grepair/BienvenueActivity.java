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
    DatabaseHelper databaseHelper;

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
        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.clearDomainTable();
        databaseHelper.addDomain("Electricité", R.drawable.electricite, "Si certaines ampoules grillent beaucoup trop souvent, il est peut-être temps de faire appel à un électricien professionnel. Trouvez votre artisan de confiance chez nous.");
        databaseHelper.addDomain("ElectroMenager", R.drawable.electromenager, "Lorsque le SAV de votre électroménager ne peut plus rien pour vous, GlobalRepair peut vous mettre en relation avec des techniciens spécialisés.");
        databaseHelper.addDomain("Jardinage", R.drawable.garden,"Vous n’ayez pas le temps de vous lancer dans les joies du jardinage,nous mettons des spécialistes équipés à votre disposition, peu importe la taille de votre jardin !");
        databaseHelper.addDomain("Plomberie", R.drawable.plomberie,"Lorsque l'inondation menace et que la pression monte, ayez le bon réflexe et faites confiance à GlobalRepair. Trouvez maintenant un plombier professionnel sur votre ville.");
        databaseHelper.addDomain("Serrurerie", R.drawable.serrurerie,"Dans l’urgence il est facile de faire des erreurs, ce qui se paye bien souvent au prix fort. Pour arrêter les frais, confiez votre ouverture de porte à GlobalRepair.");
        databaseHelper.addDomain("Vitrerie", R.drawable.vitrerie,"GlobalRepair vous propose de trouver votre expert vitrier qualifié en deux temps trois mouvements, disponible près de chez vous 7j/7.");

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

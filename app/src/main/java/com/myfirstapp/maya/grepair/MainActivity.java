package com.myfirstapp.maya.grepair;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.electricite, "Electricité", "Si certaines ampoules grillent beaucoup trop souvent,que les plombs sautent dès que vous allumez trois appareils en même temps et que certaines prises ne fonctionnent tout simplement pas, il est peut-être temps de faire appel à un électricien professionnel. Trouvez votre artisan de confiance chez nous."));
        models.add(new Model(R.drawable.plomberie, "Plomberie", "Un siphon bouché, une canalisation bruyante ou une chasse d’eau qui fuit, nous y sommes tous confrontés un jour. Lorsque l'inondation menace et que la pression monte, ayez le bon réflexe et faites confiance à MesDépanneurs.fr. Trouvez maintenant un plombier professionnel sur votre ville."));
        models.add(new Model(R.drawable.electromenager, "Electroménager", " Quand le frigo rend l’âme sans raison ou que le lave-linge s’interrompt en plein cycle, c’est toute la routine quotidienne qui se retrouve sans dessus-dessous. Lorsque le SAV de votre électroménager ne peut plus rien pour vous, GlobalRepair peut vous mettre en relation avec des techniciens spécialisés."));
        models.add(new Model(R.drawable.vitrerie, "Vitrerie", "Pour poser du double vitrage afin de ne plus avoir à entendre tous les bruits extérieurs ou simplement réparer une vitre brisée par un ballon de foot hors de contrôle, vous allez avoir besoin d’un vitrier. GlobalRepair vous propose de trouver votre expert vitrier qualifié en deux temps trois mouvements, disponible près de chez vous 7j/7."));
        models.add(new Model(R.drawable.jardinage, "Jardinage", " Semer, planter, arroser, désherber, tailler et protéger… Un jardin demande beaucoup de patience et d’entretien. Que vous n’ayez pas le temps ou pas l’envie de vous lancer dans les joies du jardinage, vous pouvez compter sur l’aide de GlobalRepair. Nous mettons des spécialistes équipés à votre disposition, peu importe la taille de votre jardin !"));
        models.add(new Model(R.drawable.serrurerie, "Serrurerie", " C’est toujours la même chose : vous claquez la porte en sortant et l’instant d’après vous réalisez que les clés sont toujours à l’intérieur. Rien de plus frustrant et agaçant. Dans l’urgence il est facile de faire des erreurs, ce qui se paye bien souvent au prix fort. Pour arrêter les frais, confiez votre ouverture de porte à GlobalRepair."));


        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 130, 130, 130);

        Integer[] colors_temp = {
                getResources().getColor(R.color.electricite),
                getResources().getColor(R.color.plomberie),
                getResources().getColor(R.color.electromenager),
                getResources().getColor(R.color.vitre),
                getResources().getColor(R.color.jardinage),
                getResources().getColor(R.color.serrurerie)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_main:
                Intent m=new Intent(MainActivity.this,MainActivity.class);
                startActivity(m);
            break;
            case R.id.nav_profile:
                Intent p=new Intent(MainActivity.this, UserActivity.class);
                startActivity(p);
                break;
            case R.id.nav_propos:
                Intent l=new Intent(MainActivity.this, About.class);
                startActivity(l);
                break;
            case R.id.nav_condition:
                Intent c=new Intent(MainActivity.this, Condition.class);
                startActivity(c);
                break;
            case R.id.nav_domaine:
                Intent d=new Intent(MainActivity.this, DomaineActivity.class);
                startActivity(d);
                break;
            case R.id.nav_historique:
                Intent h=new Intent(MainActivity.this, Historique.class);
                startActivity(h);
                break;

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}


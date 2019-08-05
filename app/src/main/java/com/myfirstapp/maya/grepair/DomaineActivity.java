package com.myfirstapp.maya.grepair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class DomaineActivity extends AppCompatActivity
        //implements NavigationView.OnNavigationItemSelectedListener
        {
            DatabaseHelper databaseHelper;
            RecyclerView recyclerView;
            List<Domain> domainList;
            LinearLayout item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_domaine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databaseHelper = new DatabaseHelper(getApplicationContext());

        recyclerView = findViewById(R.id.rv);

        domainList = new ArrayList<>();
        domainList = databaseHelper.DisplayDomain();


        /*domainList.add(new Domain("Electricité", R.drawable.electricite, "Si certaines ampoules grillent beaucoup trop souvent, il est peut-être temps de faire appel à un électricien professionnel. Trouvez votre artisan de confiance chez nous."));
        domainList.add(new Domain("ElectroMenager",R.drawable.electromenager, "Lorsque le SAV de votre électroménager ne peut plus rien pour vous, GlobalRepair peut vous mettre en relation avec des techniciens spécialisés." ));
        domainList.add(new Domain( "Jardinage",R.drawable.garden,"Vous n’ayez pas le temps de vous lancer dans les joies du jardinage,nous mettons des spécialistes équipés à votre disposition, peu importe la taille de votre jardin !"));
        domainList.add(new Domain( "Plomberie",R.drawable.plomberie,"Lorsque l'inondation menace et que la pression monte, ayez le bon réflexe et faites confiance à GlobalRepair. Trouvez maintenant un plombier professionnel sur votre ville."));
        domainList.add(new Domain( "Serrurerie",R.drawable.serrurerie,"Dans l’urgence il est facile de faire des erreurs, ce qui se paye bien souvent au prix fort. Pour arrêter les frais, confiez votre ouverture de porte à GlobalRepair."));
        domainList.add(new Domain( "Vitrerie",R.drawable.vitrerie,"GlobalRepair vous propose de trouver votre expert vitrier qualifié en deux temps trois mouvements, disponible près de chez vous 7j/7."));*/

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        DomainAdapter adapter = new DomainAdapter(this, (ArrayList<Domain>) domainList);

        recyclerView.setAdapter(adapter);




/*        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
                Intent m=new Intent(DomaineActivity.this, MainActivity.class);
                startActivity(m);
                break;
            case R.id.nav_profile:
                Intent p=new Intent(DomaineActivity.this, UserActivity.class);
                startActivity(p);
                break;
            case R.id.nav_propos:
                Intent l=new Intent(DomaineActivity.this,About.class);
                startActivity(l);
                break;
            case R.id.nav_condition:
                Intent c=new Intent(DomaineActivity.this,Condition.class);
                startActivity(c);
                break;
            case R.id.nav_domaine:
                Intent d=new Intent(DomaineActivity.this, DomaineActivity.class);
                startActivity(d);
                break;
            case R.id.nav_historique:
                Intent h=new Intent(DomaineActivity.this,Historique.class);
                startActivity(h);
                break;
            case R.id.nav_suivi:
                Intent s=new Intent(DomaineActivity.this,Suivi.class);
                startActivity(s);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true; */
    }
}

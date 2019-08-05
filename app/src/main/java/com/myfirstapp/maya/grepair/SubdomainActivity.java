package com.myfirstapp.maya.grepair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SubdomainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Subdomain> subdomainList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdomain);

        recyclerView = findViewById(R.id.rv);

        subdomainList = new ArrayList<>();

        subdomainList.add(new Subdomain( "Pharmacie"));
        subdomainList.add(new Subdomain( "Pharmacie"));
        subdomainList.add(new Subdomain( "Pharmacie"));
        subdomainList.add(new Subdomain( "Pharmacie"));
        subdomainList.add(new Subdomain( "Pharmacie"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        SubdomainAdapter adapter = new SubdomainAdapter(this,subdomainList);

        recyclerView.setAdapter(adapter);

    }
}

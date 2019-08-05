package com.myfirstapp.maya.grepair;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubdomainAdapter extends RecyclerView.Adapter<SubdomainAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Subdomain> mList;
    public SubdomainAdapter(Context context, ArrayList<Subdomain> list){
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.rv_list_subdomain,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Subdomain accueilItem = mList.get(position);
        TextView libelle;

        libelle = holder.item_name;

        libelle.setText(accueilItem.getLibelle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_name,item_commande;
        public ViewHolder(View itemView){
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_commande = itemView.findViewById(R.id.item_commande);


        }
    }
}

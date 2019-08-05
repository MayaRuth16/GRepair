package com.myfirstapp.maya.grepair;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Domain> mList;
    public DomainAdapter(Context context, ArrayList<Domain> list){
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.rv_list_domain,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Domain accueilItem = mList.get(position);
        ImageView image = holder.item_image;
        TextView name,description;

        name = holder.item_name;
        description = holder.item_desc;

        image.setImageResource(accueilItem.getImage());
        name.setText(accueilItem.getName());
        description.setText(accueilItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name,item_commande,item_desc;
        public ViewHolder(View itemView){
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_desc = itemView.findViewById(R.id.item_desc);



        }
    }
}

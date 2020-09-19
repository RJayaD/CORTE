package com.example.corte.Adaptadores;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.corte.*;
import com.example.corte.Models.*;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> implements View.OnClickListener{

    private Context mContext;
    private View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname, txtdescrip;
        ImageView Img;

        public ViewHolder( View itemView) {
            super(itemView);
            txtname= itemView.findViewById(R.id.txtname);
            txtdescrip= itemView.findViewById(R.id.txtdescrip);
            Img = itemView.findViewById(R.id.imgportada);
        }
    }
    public List<Datum> Data;
    public AdapterRecycler(Context context, List<Datum> data) {
        mContext=context;
        Data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_revista,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.txtname.setText(Data.get(position).getName());
        holder.txtdescrip.setText(Html.fromHtml( Data.get(position).getDescription()).toString());
        Glide.with(holder.Img.getContext())
                .load(Data.get(position).getPortada())
                .into(holder.Img);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }


}

package com.example.rateacher.Adapters;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.rateacher.ListItems.Comment;
import com.example.rateacher.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CommentsAdapter extends BaseAdapter {



    ArrayList<Comment> items =new ArrayList<>();

    public CommentsAdapter(ArrayList<Comment> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        CommentsAdapter.ViewHolder holder;
        if (convertView==null){
            Log.d("blu3","NULL");
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_comment,parent,false);
            holder=new CommentsAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            Log.d("blu3","NULL");
            holder=(CommentsAdapter.ViewHolder) convertView.getTag();

        }
        holder.emri.setText(items.get(position).getEmri());
        holder.komenti.setText(items.get(position).getKomenti());
        Picasso.get().load(items.get(position).getPhoto()).centerCrop().fit().into(holder.personImg);

        //-- Glide.with().load(items.get(position).getRestImgLink()).into(holder.restImg);
        //this is where you can also put eventlisteners to the views
        return convertView;
    }

    class ViewHolder{
        TextView komenti;
        TextView emri;

        ImageView personImg;
        ViewHolder(View v){
            emri=(TextView) v.findViewById(R.id.textView40);
            komenti=(TextView) v.findViewById(R.id.textView39);

            personImg=(ImageView) v.findViewById(R.id.imageView8);
        }
    }



}

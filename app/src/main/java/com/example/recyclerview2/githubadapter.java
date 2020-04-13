package com.example.recyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class githubadapter extends RecyclerView.Adapter<githubadapter.githubviewholder>{


    private User[] data;
    private Context context;
    public githubadapter(Context context,User[] data){
    this.data=data;

    this.context=context;

    }

    @NonNull
    @Override
    public githubviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator=LayoutInflater.from(parent.getContext());
        View view=inflator.inflate(R.layout.user_item,parent,false);
        return new githubviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull githubviewholder holder, int position) {
        User user=data[position];
        holder.textuser.setText(user.getLogin());
        Glide.with(holder.imguser.getContext()).load(user.getAvatarUrl()).into(holder.imguser);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class githubviewholder extends RecyclerView.ViewHolder {
        ImageView imguser;
        TextView textuser;

        public githubviewholder(@NonNull View itemView) {
            super(itemView);
            imguser=itemView.findViewById(R.id.Imgicon);
            textuser=itemView.findViewById(R.id.texttitle);
        }
    }
}

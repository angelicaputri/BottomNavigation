package com.example.user.buttonnavigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KampusAdapter extends RecyclerView.Adapter<KampusAdapter.ViewHolder> {
    Context context;
    List<KampusModel> kampusModels = new ArrayList<>();

    public KampusAdapter(Context context, List<KampusModel> kampusModels) {
        this.context = context;
        this.kampusModels = kampusModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view, viewGroup, false); // menghubungkan ke layout
        ViewHolder holder = new ViewHolder(view); // deklarasi class ViewHolder di baris 46
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvNama.setText(kampusModels.get(i).getNamaKampus());
        viewHolder.ivFoto.setImageResource(kampusModels.get(i).getPicKampus());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, kampusModels.get(i).getNamaKampus(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return kampusModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.pic);
            tvNama = itemView.findViewById(R.id.tv1);
        }
    }
}


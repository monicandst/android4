package com.example.tugas4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {
    private Context context;
    private ArrayList<MovieModel> movieModel;

    public AdapterMovie(Context context) {
        this.context = context;
    }

    public ArrayList<MovieModel> getMovieModel() {
        return movieModel;
    }

    public void setMovieModel(ArrayList<MovieModel> movieModel) {
        this.movieModel = movieModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_movie, parent, false);
        return new ViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getMovieModel().get(position).gambarfilm).into(holder.gambar);
        holder.judul.setText(getMovieModel().get(position).judulfilm);
        holder.btn_Sinopsis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sinopsis = new Intent(context, Sinopsis.class);
                sinopsis.putExtra("sinopsis", getMovieModel().get(position).getSinopsis());
                sinopsis.putExtra("gambar", getMovieModel().get(position).getGambarfilm());
                sinopsis.putExtra("judul", getMovieModel().get(position).getJudulfilm());
                context.startActivity(sinopsis);
            }
        });
        holder.btn_Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getMovieModel().get(position).getJudulfilm());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                context.startActivity(shareIntent);
            }//https://developer.android.com/training/sharing/send?hl=id#java
        });
    }

    @Override
    public int getItemCount() {
        return getMovieModel().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView judul;
        private ImageView gambar;
        private Button btn_Share, btn_Sinopsis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.text);
            gambar = itemView.findViewById(R.id.img);
            btn_Share = itemView.findViewById(R.id.btn_share);
            btn_Sinopsis = itemView.findViewById(R.id.btn_sinopsis);
        }
    }
}

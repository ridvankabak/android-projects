package com.ridvankabak.mvp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ridvankabak.mvp.MainActivity.MainActivity;
import com.ridvankabak.mvp.Model.Photo;
import com.ridvankabak.mvp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.CardViewTasarimTutucu> {
    private MainActivity mainActivity;
    private List<Photo> photoList;


    public PhotoAdapter(MainActivity mainActivity, List<Photo> photoList) {
        this.mainActivity = mainActivity;
        this.photoList = photoList;

    }

    @NonNull
    @Override
    public CardViewTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);

        return new CardViewTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucu holder, int position) {
        Photo photo = photoList.get(position);
        String photoCome = "https://farm"+photo.getFarm()+".staticflickr.com/"+photo.getServer()+"/"+photo.getId()+"_"+photo.getSecret()+".jpg";

        Picasso.get().load(photoCome).into(holder.satirImage);
        holder.satirYazi.setText(photo.getTitle());

       holder.satirCard.setOnClickListener(view -> {
           mainActivity.onPhotoItemClick(photoCome);
        });

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class CardViewTasarimTutucu extends RecyclerView.ViewHolder{
        public TextView satirYazi;
        public ImageView satirImage;
        public CardView satirCard;

        public CardViewTasarimTutucu (View view){
            super(view);
            satirYazi = view.findViewById(R.id.textViewTitle);
            satirImage = view.findViewById(R.id.imageViewGelPic);
            satirCard = view.findViewById(R.id.foto_card);
        }
    }

}

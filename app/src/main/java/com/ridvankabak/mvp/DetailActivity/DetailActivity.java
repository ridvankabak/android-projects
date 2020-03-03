package com.ridvankabak.mvp.DetailActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.ridvankabak.mvp.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements DetailActivityContract.View {
    String photoCome;
    ImageView imageViewDetayBackground,imageViewBack;

    DetailActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initUI();

        setListener();

        photoCome = getIntent().getStringExtra("nesne");

        mPresenter = new DetailActivityPresenter(this);
        mPresenter.getPhoto(photoCome);


    }

    private void initUI() {
        imageViewDetayBackground = findViewById(R.id.imageViewDetayBackground);
        imageViewBack = findViewById(R.id.imageViewBack);
    }

    private void setListener() {
        imageViewBack.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void setPhotoToViews(String photoCome) {
        Picasso.get().load(photoCome).into(imageViewDetayBackground);
    }
}

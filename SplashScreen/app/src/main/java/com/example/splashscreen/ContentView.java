package com.example.splashscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

@SuppressLint("AppCompatCustomView")
public class ContentView extends ImageView {
    public ContentView(Context context){
        super(context);
        initialize();
    }

    private void initialize(){
        // set the dummy content image here
        setImageResource(R.drawable.asdf);
    }

}

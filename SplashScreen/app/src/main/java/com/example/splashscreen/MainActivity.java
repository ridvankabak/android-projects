package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final boolean DO_XML = false;

    private ViewGroup mMainView;
    private SplashView mSplashView;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // change the DO_XML variable to switch between code and xml
        if(DO_XML){
            // inflate the view from XML and then get a reference to it
            setContentView(R.layout.activity_main);
            mMainView = (ViewGroup) findViewById(R.id.main_view);
            mSplashView = (SplashView) findViewById(R.id.splash_view);
        } else {
            // create the main view and it will handle the rest
            mMainView = new MainView(getApplicationContext());
            mSplashView = ((MainView) mMainView).getSplashView();
            setContentView(mMainView);
        }

        // pretend like we are loading data
        startLoadingData();
    }

    private void startLoadingData(){
        // finish "loading data" in a random time between 1 and 3 seconds
        Random random = new Random();
        mHandler.postDelayed(new Runnable(){
            @Override
            public void run(){
                onLoadingDataEnded();
            }
        }, 1000 + random.nextInt(2000));
    }

    private void onLoadingDataEnded(){

        // start the splash animation
        mSplashView.splashAndDisappear(new SplashView.ISplashListener(){
            @Override
            public void onStart(){
                // log the animation start event
                if(BuildConfig.DEBUG){
                    Log.d(TAG, "splash started");

                }
            }

            @Override
            public void onUpdate(float completionFraction){
                // log animation update events
                if(BuildConfig.DEBUG){
                    Log.d(TAG, "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
                }

            }

            @Override
            public void onEnd(){
                // log the animation end event
                if(BuildConfig.DEBUG){
                    Log.d(TAG, "splash ended");
                }
                // free the view so that it turns into garbage
                mSplashView = null;
                if(!DO_XML){
                    // if inflating from code we will also have to free the reference in MainView as well
                    // otherwise we will leak the View, this could be done better but so far it will suffice
                    ((MainView) mMainView).unsetSplashView();
                }
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                overridePendingTransition(0, 0);
                finish();

            }
        });

    }
}
package com.ridvankabak.mvp.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ridvankabak.mvp.Adapter.PhotoAdapter;
import com.ridvankabak.mvp.DetailActivity.DetailActivity;
import com.ridvankabak.mvp.Model.Photo;
import com.ridvankabak.mvp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    private static final String TAG = "MovieListActivity";
    private MainActivityContract.Presenter mPresenter;
    private RecyclerView rv;
    private ProgressBar pbLoading;
    PhotoAdapter adapter;
    List<Photo> photoList,newData;

    private int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        setListener();

        mPresenter = new MainActivityPresenter(this);
        mPresenter.requestFromDataServer();
    }



    private void initUI() {
        rv = findViewById(R.id.rv);
        photoList = new ArrayList<>();
        adapter = new PhotoAdapter(this,photoList);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(adapter);

        pbLoading = findViewById(R.id.pb_loading);

    }
    private void setListener() {
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(isLastItemDisplaying(recyclerView)){
                    showProgress();
                    mPresenter.getMoreData(pageNo);
                    Log.e("Main Activity","Load More");
                }

            }
        });

    }

    @Override
    public void setDataToRecyclerView(List<Photo> photoArrayList) {
        photoList.addAll(photoArrayList);
        adapter.notifyDataSetChanged();

        // This will help us to fetch data from next page no.
        pageNo++;
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
        Toast.makeText(this, "Error in getting data. Please try again later.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPhotoItemClick(String photoCome) {
        if (photoCome == null) {
            return;
        }
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("nesne",photoCome);
        startActivity(detailIntent);
    }

    private boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if(recyclerView.getAdapter().getItemCount() != 0){
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();

            if(lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)

                return true;
        }

        return false;
    }

}

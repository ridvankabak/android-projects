package com.ridvankabak.mvp.MainActivity;

import android.util.Log;

import com.ridvankabak.mvp.Model.Photo;
import com.ridvankabak.mvp.Model.PhotoResponse;
import com.ridvankabak.mvp.Model.Photos;
import com.ridvankabak.mvp.Service.ApiUtils;
import com.ridvankabak.mvp.Service.AppcentDaoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityModel implements MainActivityContract.Model {
    private final String TAG = "MainActivityModel";

    @Override
    public void getPhotoList(OnFinishedListener onFinishedListener, int pageNo) {
        AppcentDaoInterface appcentDIF = ApiUtils.getAppcentDaoInterface();

        appcentDIF.tumFotolar(ApiUtils.METHOD,ApiUtils.API_KEY,
                ApiUtils.PER_PAGE,ApiUtils.FORMAT,
                ApiUtils.NO_JSON_CALL_BACK,
                String.valueOf(pageNo)).enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                Photos photos = response.body().getPhotos();
                List<Photo> photo = photos.getPhoto();
                Log.e(TAG,photo.toString());
                onFinishedListener.onFinished(photo);
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}

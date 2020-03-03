package com.ridvankabak.mvp.DetailActivity;

public class DetailActivityPresenter implements DetailActivityContract.Presenter {

    private DetailActivityContract.View mView;

    public DetailActivityPresenter(DetailActivityContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getPhoto(String photoCome) {
        mView.setPhotoToViews(photoCome);
    }
}

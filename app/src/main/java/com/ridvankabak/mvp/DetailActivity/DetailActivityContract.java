package com.ridvankabak.mvp.DetailActivity;

public interface DetailActivityContract {
    interface View{

        void setPhotoToViews(String photoCome);
    }
    interface Presenter{

        void getPhoto(String photoCome);
    }
}

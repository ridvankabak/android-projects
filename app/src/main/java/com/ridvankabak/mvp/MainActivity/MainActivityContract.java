package com.ridvankabak.mvp.MainActivity;

import com.ridvankabak.mvp.Model.Photo;

import java.util.List;

public interface MainActivityContract {

    interface  View {

        void setDataToRecyclerView(List<Photo> photoArrayList);

        void showProgress();

        void hideProgress();

        void onResponseFailure(Throwable throwable);

        void onPhotoItemClick(String photoCome);
    }

    interface Model {
        interface OnFinishedListener {
            void onFinished(List<Photo> movieArrayList);

            void onFailure(Throwable t);
        }

        void getPhotoList(OnFinishedListener onFinishedListener, int pageNo);
    }

    interface Presenter {


        void requestFromDataServer();

        void getMoreData(int pageNo);
    }
}

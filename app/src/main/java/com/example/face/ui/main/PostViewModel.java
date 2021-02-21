package com.example.face.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.face.data.PostsClient;
import com.example.face.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    private static final String TAG = "PostViewModel";
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> post = new MutableLiveData<>();

    public void getposts(){
        Single<List<PostModel>> observable =  PostsClient.getINSTANCE().getposts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(o-> postMutableLiveData.setValue(o), e-> Log.d(TAG, "get Post " + e));



      //  observable.subscribe(observer);
    }
}

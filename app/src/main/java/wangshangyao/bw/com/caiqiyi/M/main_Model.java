package wangshangyao.bw.com.caiqiyi.M;

import okhttp3.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wangshangyao.bw.com.caiqiyi.Api;
import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

/**
 * Created by Administrator on 2017/11/27.
 */

public class main_Model implements IModel2 {
    @Override
    public void getData(Observer o) {
        new Retrofit.Builder()
            .baseUrl("http://api.svipmovie.com/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class)
            .callback()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(o);
    }
}

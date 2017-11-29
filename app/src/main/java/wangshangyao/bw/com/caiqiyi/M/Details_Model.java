package wangshangyao.bw.com.caiqiyi.M;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wangshangyao.bw.com.caiqiyi.Api;

/**
 * Created by Administrator on 2017/11/27.
 */

public class Details_Model implements IModel {

    @Override
    public void getData(Observer o, String dataId) {
        new Retrofit.Builder()
                .baseUrl("http://api.svipmovie.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class)
                .CallbackDetails(dataId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o);
    }
}

package wangshangyao.bw.com.caiqiyi.M;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/11/27.
 */

public class recommend_Model implements IModel {
    @Override
    public void getData(Callback callback) {
        OkHttpClient ok = new OkHttpClient();
        Request r = new Request.Builder()
                .url("http://api.svipmovie.com/front/homePageApi/homePage.do")
                .build();
        Call call = ok.newCall(r);
        call.enqueue(callback);
    }
}

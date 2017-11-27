package wangshangyao.bw.com.caiqiyi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wangshangyao.bw.com.caiqiyi.banner.BannerAdapter;
import wangshangyao.bw.com.caiqiyi.banner.BannerBaseAdapter;
import wangshangyao.bw.com.caiqiyi.banner.BannerBean;
import wangshangyao.bw.com.caiqiyi.banner.BannerView;

public class MainActivity extends AppCompatActivity {

    private BannerView bannerview;
    private BannerAdapter mAdapter;
    private List<BannerBean> datas = new ArrayList<>();
    private Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            datas.clear();

            String json = (String) msg.obj;
            try {
                JSONObject js = new JSONObject(json);
                JSONArray data = js.getJSONArray("data");
                for(int i=0;i<data.length();i++){
                    JSONObject jo = data.getJSONObject(i);
                    String title = jo.getString("title");
                    String img = jo.getString("img");
                    datas.add(new BannerBean(img,title));
                }
                mAdapter.setData(datas);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bannerview = (BannerView) findViewById(R.id.bannerView);

        bannerview.setAdapter(mAdapter = new BannerAdapter(this));

        mAdapter.setOnPageTouchListener(new BannerBaseAdapter.OnPageTouchListener<BannerBean>() {
            @Override
            public void onPageClick(int position, BannerBean bannerBean) {
                // 页面点击
                Toast.makeText(MainActivity.this, bannerBean.title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageDown() {
                // 按下，可以停止轮播
                //   Toast.makeText(BannerActivity.this, "按下", Toast.LENGTH_SHORT).show();
                bannerview.stopAutoScroll();
            }

            @Override
            public void onPageUp() {
                // 抬起开始轮播
                //  Toast.makeText(BannerActivity.this, "抬起", Toast.LENGTH_SHORT).show();
                bannerview.startAutoScroll();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient ok = new OkHttpClient.Builder().build();
                Request r = new Request.Builder()
                        .url("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1")
                        .build();
                Call call = ok.newCall(r);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("xx","失败啦");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Message msg = new Message();
                        msg.obj = response.body().string();
                        h.sendMessage(msg);
                    }
                });
            }
        }).start();

    }

}
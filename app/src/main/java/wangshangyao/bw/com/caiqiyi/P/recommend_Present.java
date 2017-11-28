package wangshangyao.bw.com.caiqiyi.P;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import wangshangyao.bw.com.caiqiyi.M.IModel;
import wangshangyao.bw.com.caiqiyi.M.recommend_Model;
import wangshangyao.bw.com.caiqiyi.V.IView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class recommend_Present implements IPresent {
    private IView v;
    private IModel m;

    public recommend_Present(IView v) {
        this.v = v;
        this.m = new recommend_Model();
    }

    @Override
    public void relation() {
        m.getData(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                List<BannerBean> arr = new ArrayList<>();
                try {
                    JSONObject js = new JSONObject(json);
                    JSONObject ret = js.getJSONObject("ret");
                    JSONArray list = ret.getJSONArray("list");
                    for(int i=0;i<list.length();i++){
                        JSONObject jo = list.getJSONObject(i);
                        if(jo.getString("showType").equals("banner")){
                            JSONArray childList = jo.getJSONArray("childList");
                            for(int j=0;j<childList.length();j++){
                                JSONObject ch_jo = childList.getJSONObject(j);
                                String airTime = ch_jo.getString("airTime");
                                String angleIcon = ch_jo.getString("angleIcon");
                                String dataId = ch_jo.getString("dataId");
                                String description = ch_jo.getString("description");
                                String duration = ch_jo.getString("duration");
                                String loadType = ch_jo.getString("loadType");
                                String loadURL = ch_jo.getString("loadURL");
                                String pic = ch_jo.getString("pic");
                                String roomId = ch_jo.getString("roomId");
                                String shareURL = ch_jo.getString("shareURL");
                                String title = ch_jo.getString("title");
                                int score = ch_jo.getInt("score");
                                //arr.add(new BannerBean(airTime,angleIcon,dataId,description,duration,loadType,loadURL,pic,roomId,shareURL,title,score));
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                v.showView(arr);
            }
        });
    }
}

package wangshangyao.bw.com.caiqiyi.V;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.yao.banner.BannerAdapter;
import com.bw.yao.banner.BannerBaseAdapter;
import com.bw.yao.banner.BannerBean;
import com.bw.yao.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

import wangshangyao.bw.com.caiqiyi.P.IPresent;
import wangshangyao.bw.com.caiqiyi.R;

/**
 * Created by Administrator on 2017/11/27.
 */

public class fr_Recommend extends Fragment implements IView<BannerBean>{

    private Context con;
    private MainBean b;

    public fr_Recommend(Context con,MainBean b) {
        this.con = con;
        this.b = b;
    }

    private BannerView bannerview;
    private BannerAdapter mAdapter;
    private IPresent p;

    private List<BannerBean> arr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(con, R.layout.recommend, null);

        bannerview = v.findViewById(R.id.bannerView);
        bannerview.setAdapter(mAdapter = new BannerAdapter(con));

        /*p = new recommend_Present(this);
        p.relation();*/

        onMyEvent();

        return v;
    }

    /**
     * 我的事件们
     * */
    private void onMyEvent() {

        arr = new ArrayList<>();
        for(int i=0;i<b.getRet().getList().get(0).getChildList().size();i++){
            arr.add(new BannerBean(b.getRet().getList().get(0).getChildList().get(i).getPic(),b.getRet().getList().get(0).getChildList().get(i).getTitle()));
        }
        mAdapter.setData(arr);


        mAdapter.setOnPageTouchListener(new BannerBaseAdapter.OnPageTouchListener<BannerBean>() {
            @Override
            public void onPageClick(int position, BannerBean bannerBean) {
                // 页面点击
                Toast.makeText(con, bannerBean.title, Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void showView(List<BannerBean> t) {
    }
}

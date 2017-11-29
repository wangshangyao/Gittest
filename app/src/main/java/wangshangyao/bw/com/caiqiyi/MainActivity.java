package wangshangyao.bw.com.caiqiyi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import wangshangyao.bw.com.caiqiyi.Adapter.Vp_adapter;
import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;
import wangshangyao.bw.com.caiqiyi.P.main_Present;
import wangshangyao.bw.com.caiqiyi.V.IView;
import wangshangyao.bw.com.caiqiyi.V.dkjc;
import wangshangyao.bw.com.caiqiyi.V.dpqxk;
import wangshangyao.bw.com.caiqiyi.V.dyzx;
import wangshangyao.bw.com.caiqiyi.V.fr_Recommend;
import wangshangyao.bw.com.caiqiyi.V.hlw;
import wangshangyao.bw.com.caiqiyi.V.jctj;
import wangshangyao.bw.com.caiqiyi.V.wdy;
import wangshangyao.bw.com.caiqiyi.V.xgyx;

public class MainActivity extends AppCompatActivity implements IView<MainBean> {

    private TabLayout tab;
    private ViewPager vp;

    private String[] b = new String[]{"推荐","大咖剧场","大片抢先看","电影资讯","好莱坞","精彩推荐","微电影","香港影视"};
    private List<Fragment> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = new ArrayList<>();

        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.main_vp);

        main_Present p = new main_Present(this);
        p.relation();
    }

    @Override
    public void showView(List<MainBean> t) {

        arr.add(new fr_Recommend(this,t.get(0)));
        arr.add(new dkjc(this,t.get(0)));
        arr.add(new dpqxk(this));
        arr.add(new dyzx(this));
        arr.add(new hlw(this));
        arr.add(new jctj(this));
        arr.add(new wdy(this));
        arr.add(new xgyx(this));

        vp.setAdapter(new Vp_adapter(getSupportFragmentManager(),arr,b));
        tab.setupWithViewPager(vp);
    }
}
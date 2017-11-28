package wangshangyao.bw.com.caiqiyi.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

/**
 * Created by Administrator on 2017/11/27.
 */

public class Vp_adapter extends FragmentPagerAdapter {

    List<Fragment> arr;
    String[] b;

    public Vp_adapter(FragmentManager fm, List<Fragment> arr, String[] b) {
        super(fm);
        this.arr = arr;
        this.b = b;
    }

    @Override
    public Fragment getItem(int position) {
        return arr.get(position);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return b[position];
    }
}

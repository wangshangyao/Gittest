package wangshangyao.bw.com.caiqiyi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

/**
 * Created by Administrator on 2017/11/28.
 */

public class Lv_adapter extends BaseAdapter {

    private Context con;
    private MainBean b;

    public Lv_adapter(Context con, MainBean b) {
        this.con = con;
        this.b = b;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

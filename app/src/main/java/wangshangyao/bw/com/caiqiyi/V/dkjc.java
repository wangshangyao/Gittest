package wangshangyao.bw.com.caiqiyi.V;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

/**
 * Created by Administrator on 2017/11/27.
 */

public class dkjc extends Fragment {
    private Context con;
    private MainBean b;

    public dkjc(Context con,MainBean b) {
        this.con = con;
        this.b = b;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView t = new TextView(con);
        t.setText("占地的");
        return t;
    }
}

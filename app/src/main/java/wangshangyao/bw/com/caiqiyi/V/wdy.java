package wangshangyao.bw.com.caiqiyi.V;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class wdy extends Fragment {
    Context con;

    public wdy(Context con) {
        this.con = con;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView t = new TextView(con);
        t.setText("占地的");
        return t;
    }
}

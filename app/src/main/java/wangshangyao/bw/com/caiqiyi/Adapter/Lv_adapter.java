package wangshangyao.bw.com.caiqiyi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;
import wangshangyao.bw.com.caiqiyi.BaseView.MyGridView;
import wangshangyao.bw.com.caiqiyi.R;
import wangshangyao.bw.com.caiqiyi.V.Details;

/**
 * Created by Administrator on 2017/11/28.
 */

public class Lv_adapter extends BaseAdapter {

    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;
    private final int TYPE_3 = 2;

    private Context con;
    private MainBean b;

    public Lv_adapter(Context con, MainBean b) {
        this.con = con;
        this.b = b;
    }

    @Override
    public int getCount() {
        return b.getRet().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return b.getRet().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        if(v == null){
            v = View.inflate(con, R.layout.lv_item_type_1,null);
        }
        TextView title = v.findViewById(R.id.title);
        MyGridView grid = v.findViewById(R.id.grid);
        title.setText(b.getRet().getList().get(position).getTitle());
        switch (getItemViewType(position)){
            case TYPE_1:
                grid.setNumColumns(1);
                if(position == 2){
                    grid.setNumColumns(2);
                }
                grid.setAdapter(new Gr_adapter(1,b.getRet().getList().get(position).getChildList(),con));
                break;
            case TYPE_2:
                grid.setNumColumns(2);
                grid.setAdapter(new Gr_adapter(2,b.getRet().getList().get(position).getChildList(),con));
                break;
            case TYPE_3:
                grid.setNumColumns(1);
                if(position == 0){
                    grid.setNumColumns(3);
                }
                grid.setAdapter(new Gr_adapter(1,b.getRet().getList().get(position).getChildList(),con));
                break;
        }
        return v;
    }

    @Override
    public int getItemViewType(int position) {
        MainBean.RetBean.ListBean listBean = b.getRet().getList().get(position);
        if(listBean.getLine() == 1 && !listBean.getShowType().equals("banner")){
            return TYPE_1;
        }else if (listBean.getLine() == 2 ){
            return TYPE_2;
        }
        return TYPE_3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}

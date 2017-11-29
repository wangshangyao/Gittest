package wangshangyao.bw.com.caiqiyi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;
import wangshangyao.bw.com.caiqiyi.R;
import wangshangyao.bw.com.caiqiyi.V.Details;

/**
 * Created by Administrator on 2017/11/28.
 */

public class Gr_adapter extends BaseAdapter {
    private int type;
    private List<MainBean.RetBean.ListBean.ChildListBean> arr;
    private Context con;

    public Gr_adapter(int type, List<MainBean.RetBean.ListBean.ChildListBean> arr, Context con) {
        this.type = type;
        this.arr = arr;
        this.con = con;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        if(v == null){
            if(type == 1){
                v = View.inflate(con, R.layout.gr_item_type_1,null);
            }else if(type == 2){
                v = View.inflate(con, R.layout.gr_item_type_2,null);
            }
        }
        TextView title = v.findViewById(R.id.gr_title);
        ImageView img = v.findViewById(R.id.gr_img);
        title.setText(arr.get(position).getTitle());
        if(!arr.get(position).getPic().equals("")){
            Picasso.with(con).load(arr.get(position).getPic()).into(img);
        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(con, Details.class);
                it.putExtra("dataId",arr.get(position).getDataId());
                con.startActivity(it);
            }
        });
        return v;
    }
}

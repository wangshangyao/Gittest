package wangshangyao.bw.com.caiqiyi.banner;

import android.content.Context;
import android.view.View;

import wangshangyao.bw.com.caiqiyi.R;

/**
 * Created by Administrator on 2017/11/27.
 */

public class BannerAdapter extends BannerBaseAdapter<BannerBean> {

    public BannerAdapter(Context context) {
        super(context);
    }
    @Override
    protected int getLayoutResID() {
        return R.layout.item_banner;
    }
    @Override
    protected void convert(View convertView, BannerBean data) {
        setImage(R.id.pageImage, data.imageUrl);
        setText(R.id.pageText, data.title);
    }
}

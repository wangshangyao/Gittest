package wangshangyao.bw.com.caiqiyi.banner;

import android.support.annotation.IntegerRes;

/**
 * Created by Administrator on 2017/11/27.
 */

public class BannerBean {
    public String imageUrl;
    public String title;
    public @IntegerRes
    int imageRes;

    public BannerBean(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }

    public BannerBean(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }
    // 图片宽高传过来时一般是统一的，所以这里不处理
}

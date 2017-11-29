package wangshangyao.bw.com.caiqiyi;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import wangshangyao.bw.com.caiqiyi.BaseBean.DetailsBean;
import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;

/**
 * Created by Administrator on 2017/11/27.
 */

public interface Api {
    @GET("front/homePageApi/homePage.do")
    Observable<MainBean> callback();
    @GET("front/videoDetailApi/videoDetail.do?&")
    Observable<DetailsBean> CallbackDetails(@Query("mediaId")String mediaId);
}

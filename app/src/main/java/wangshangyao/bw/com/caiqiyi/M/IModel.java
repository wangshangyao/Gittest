package wangshangyao.bw.com.caiqiyi.M;

import okhttp3.Callback;
import rx.Observer;

/**
 * Created by Administrator on 2017/11/27.
 */

public interface IModel<T> {
    void getData(Observer<T> o,String dataId);
}

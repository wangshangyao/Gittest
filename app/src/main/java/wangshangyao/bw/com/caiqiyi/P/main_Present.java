package wangshangyao.bw.com.caiqiyi.P;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import wangshangyao.bw.com.caiqiyi.BaseBean.MainBean;
import wangshangyao.bw.com.caiqiyi.M.IModel;
import wangshangyao.bw.com.caiqiyi.M.IModel2;
import wangshangyao.bw.com.caiqiyi.M.main_Model;
import wangshangyao.bw.com.caiqiyi.M.recommend_Model;
import wangshangyao.bw.com.caiqiyi.V.IView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class main_Present implements IPresent {
    private IView v;
    private IModel2 m;

    public main_Present(IView v) {
        this.v = v;
        this.m = new main_Model();
    }

    @Override
    public void relation() {
        m.getData(new Observer<MainBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean o) {
                List<MainBean> arr = new ArrayList<>();
                arr.add(o);
                v.showView(arr);
            }
        });
    }
}

package wangshangyao.bw.com.caiqiyi.P;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observer;
import wangshangyao.bw.com.caiqiyi.BaseBean.DetailsBean;
import wangshangyao.bw.com.caiqiyi.M.IModel;
import wangshangyao.bw.com.caiqiyi.M.Details_Model;
import wangshangyao.bw.com.caiqiyi.V.IView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class Details_Present implements IPresent {
    private IView v;
    private IModel m;

    public Details_Present(IView v) {
        this.v = v;
        this.m = new Details_Model();
    }



    @Override
    public void relation(String dataId) {
        m.getData(new Observer<DetailsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DetailsBean detailsBean) {
                List<DetailsBean> arr = new ArrayList<DetailsBean>();
                arr.add(detailsBean);
                v.showView(arr);
            }
        }, dataId);
    }

    @Override
    public void relation() {

    }
}

package wangshangyao.bw.com.caiqiyi.V;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wangshangyao.bw.com.caiqiyi.BaseBean.DetailsBean;
import wangshangyao.bw.com.caiqiyi.P.Details_Present;
import wangshangyao.bw.com.caiqiyi.R;

public class Details extends AppCompatActivity implements IView<DetailsBean>{
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent it = getIntent();
        String dataId = it.getStringExtra("dataId");
        Details_Present p = new Details_Present(this);
        p.relation(dataId);

        //找控件
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);


    }

    /**
     * 不要忘了这两个方法
     * */
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void showView(List<DetailsBean> t) {
        //设置视频上显示的文字 并且 播放视频
        jcVideoPlayerStandard.setUp(t.get(0).getRet().getSDURL().replace(".m3u8",".mp4"),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,t.get(0).getRet().getTitle());


    }
}

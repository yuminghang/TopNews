package ymh.example.com.sanrennews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.LogRecord;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyRecyclerViewAdapter;
import ymh.example.com.sanrennews.bean.JsonBean;
import ymh.example.com.sanrennews.utils.HttpUtils;

/**
 * Created by ymh on 2016/3/8.
 */
public class TuijianFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    public ArrayList<JsonBean> datas;
    private String cacheString = "[{\"title\":\"狗链SM柳侑绮Sevenbaby越南大叻撩人白色蕾丝 (58)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_e22f8ec55cfec02ebf38f45e546d0dfa-760x500.jpg\",\"h\":\"http://m.xxxiao.com/41696\"},{\"title\":\"黛欣霓爆乳野辣写真 (35)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_952ef7f7e44e4bdaf7718d20c99d66ff4-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/xinggan\"},{\"title\":\"肉感娜露Selena丰臀翘乳诱惑写真 (50)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_52138709f3e095948ad380a2233dee0d-760x500.jpg\",\"h\":\"http://m.xxxiao.com/41696\"},{\"title\":\"超跑尤物金子熙酥胸长腿冷艳魅惑 (25)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_30d56f73ea71fb6489fa23402abc8467-760x500.jpg\",\"h\":\"http://m.xxxiao.com/647\"},{\"title\":\"可人妹子嘉琳winna清纯私房照 (39)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_33fc13d272e104b584cd18e4693b0a59-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/xinggan\"},{\"title\":\"娇媚心儿前凸后翘惹火私拍 (4)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/11/m.xxxiao.com_a44a105757109c91dcda8cae6d909901-760x500.jpg\",\"h\":\"http://m.xxxiao.com/647\"},{\"title\":\"气质美女于大小姐(于雯)难得可爱美照 (25)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_55347f06da00b125795098d40a5cc1d5-760x500.jpg\",\"h\":\"http://m.xxxiao.com/30341\"},{\"title\":\"清纯美女那奈高清壁纸 (8)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_470f43c12748f3b4042a6ab12c59acaf-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/mrxt\"},{\"title\":\"养眼夏美酱私房内衣美照 (42)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_e0faaf1be002cd5d8922471c943c685e-760x500.jpg\",\"h\":\"http://m.xxxiao.com/30341\"},{\"title\":\"妩媚王尔琳透视鱼骨连体衣黑纱金鱼尾小短裙 (31)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_9dcf5a5c63923e2d68d573f251f27951-760x500.jpg\",\"h\":\"http://m.xxxiao.com/27970\"},{\"title\":\"性感美女郑瑞熙Mirui娉婷紧致婉润多姿 (28)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_a654415936a78b8ce3b063ca5e126654-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/xinggan\"},{\"title\":\"柳侑绮Sevenbaby蕾丝内衣私房写真 (8)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_18f5ded13160934fda6ceac0ac835a47-760x500.jpg\",\"h\":\"http://m.xxxiao.com/27970\"},{\"title\":\"极品性感尤物邹晶晶诱惑私房照 (14)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_d4128610104113ac2960a9881916f52b-760x500.jpg\",\"h\":\"http://m.xxxiao.com/11274\"},{\"title\":\"性感少妇张美荧激情私房照 (52)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_c3a840b6e165dd30a98346c93c60f370-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/xinggan\"},{\"title\":\"杉原杏璃Sugihara Anri沙滩比基尼写真 (59)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_68768e0d2c8fb34c021bbb3cd310bad8-760x500.jpg\",\"h\":\"http://m.xxxiao.com/11274\"},{\"title\":\"清纯逢泽莉娜(逢沢りな)王道美少女性感沙滩 (54)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_e8053baad8cde33414282c2a388ba57c-760x500.jpg\",\"h\":\"http://m.xxxiao.com/3986\"},{\"title\":\"气质美女SISY思性感普吉岛旅拍 (39)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_e681d70f5f0abcb1f8a82de54258dab0-760x500.jpg\",\"h\":\"http://m.xxxiao.com/cat/wmxz\"},{\"title\":\"佘贝拉bella三亚大尺度诱惑写真 (51)\",\"imgurl1\":\"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/02/m.xxxiao.com_54fae7bb878f6478663171a06f605438-760x500.jpg\",\"h\":\"http://m.xxxiao.com/3986\"}]";
    private Gson gson;
    private String url = "http://120.27.41.245:3000/toutiaoc_wenge";

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            datas = (gson.fromJson(msg.getData().getString("content"), new TypeToken<ArrayList<JsonBean>>() {
            }.getType()));
            mAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
            mRecyclerView.setAdapter(mAdapter);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        gson = new Gson();
        getCacheData();

        HttpUtils.getData(url, handler);

//        mAdapter.notifyDataSetChanged();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    private void getCacheData() {
        datas = (gson.fromJson(cacheString, new TypeToken<ArrayList<JsonBean>>() {
        }.getType()));
    }

}

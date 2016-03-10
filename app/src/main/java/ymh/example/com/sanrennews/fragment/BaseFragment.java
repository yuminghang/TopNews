package ymh.example.com.sanrennews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyRecyclerViewAdapter;
import ymh.example.com.sanrennews.bean.jsonbean2;
import ymh.example.com.sanrennews.utils.HttpUtils;
import ymh.example.com.sanrennews.utils.UrlUtils;

/**
 * Created by ymh on 2016/3/10.
 */
public class BaseFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    public jsonbean2 datas;
    private String cacheString = UrlUtils.CACHE_URL;
    private String resString;
    private Gson gson;
    private String url;

    public BaseFragment(String url) {
        this.url = url;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            datas = (gson.fromJson(msg.getData().getString("content"), new TypeToken<jsonbean2>() {
            }.getType()));
            mAdapter = new MyRecyclerViewAdapter(getActivity(), datas);
            AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
            ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
            scaleInAnimationAdapter.setFirstOnly(false);
            mRecyclerView.setAdapter(scaleInAnimationAdapter);
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
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        scaleInAnimationAdapter.setFirstOnly(false);
        mRecyclerView.setAdapter(scaleInAnimationAdapter);


        return view;
    }

    private void getCacheData() {
        datas = (gson.fromJson(cacheString, new TypeToken<jsonbean2>() {
        }.getType()));
    }

}

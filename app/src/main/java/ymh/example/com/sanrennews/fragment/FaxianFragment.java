package ymh.example.com.sanrennews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.FaxianRecyclerviewAdapter;
import ymh.example.com.sanrennews.bean.Faxianjsonbean;
import ymh.example.com.sanrennews.utils.HttpUtils;
import ymh.example.com.sanrennews.utils.UrlUtils;

/**
 * Created by ymh on 2016/3/11.
 */
public class FaxianFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FaxianRecyclerviewAdapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;
    public Faxianjsonbean datas;
    private String cacheString = UrlUtils.CACHE_URL;
    private String resString;
    private Gson gson;
    private String url;

    public FaxianFragment(String url) {
        this.url = url;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            datas = (gson.fromJson(msg.getData().getString("content"), new TypeToken<Faxianjsonbean>() {
            }.getType()));
            mAdapter = new FaxianRecyclerviewAdapter(getActivity(), datas);
            AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
            ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
            scaleInAnimationAdapter.setFirstOnly(false);
            mRecyclerView.setAdapter(scaleInAnimationAdapter);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxianfragment_layout, container, false);
        gson = new Gson();
//        getCacheData();

//        mAdapter.notifyDataSetChanged();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        HttpUtils.getData(url, handler);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new FaxianRecyclerviewAdapter(getActivity(), datas);
//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
//        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
//        scaleInAnimationAdapter.setFirstOnly(false);
//        mRecyclerView.setAdapter(scaleInAnimationAdapter);


        return view;
    }

    private void getCacheData() {
        datas = (gson.fromJson(cacheString, new TypeToken<Faxianjsonbean>() {
        }.getType()));
    }

}

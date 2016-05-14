package ymh.example.com.sanrennews.fragment.homeDetailFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyRecyclerViewAdapter;
import ymh.example.com.sanrennews.bean.toutiaobean;
import ymh.example.com.sanrennews.utils.DividerLine;
import ymh.example.com.sanrennews.utils.HttpUtils;

/**
 * Created by ymh on 2016/3/8.
 */
public class RedianFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private Gson gson;
    private String url;

    public RedianFragment(String url) {
        this.url = url;
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                toutiaobean content = gson.fromJson(msg.getData().getString("content"), toutiaobean.class);
                mAdapter = new MyRecyclerViewAdapter(getActivity(), content);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            } catch (Exception e) {

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        gson = new Gson();
        HttpUtils.getData(url, handler);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyRecyclerViewAdapter(getActivity(), datas1);
//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
//        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
//        scaleInAnimationAdapter.setFirstOnly(false);
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(3);
        dividerLine.setColor(0xFDDDDDDD);
        mRecyclerView.addItemDecoration(dividerLine);
        return view;
    }
}

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyRecyclerViewAdapter;
import ymh.example.com.sanrennews.bean.JsonBean;
import ymh.example.com.sanrennews.bean.jsonbean2;
import ymh.example.com.sanrennews.utils.HttpUtils;

/**
 * Created by ymh on 2016/3/8.
 */
public class MeinvFragment extends BaseFragment {
    public MeinvFragment(String url) {
        super(url);
    }
}

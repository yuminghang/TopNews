package ymh.example.com.sanrennews.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ymh.example.com.sanrennews.R;

/**
 * Created by ymh on 2016/3/11.
 */
public class SettingFragment extends Fragment {
    Context context;
    LayoutInflater mlayoutInflater;
    View view;

    public SettingFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting_layout, container, false);
        return view;
    }
}

package ymh.example.com.sanrennews.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyFragmentPagerAdapter;
import ymh.example.com.sanrennews.fragment.HomeDetailFragment.GaoxiaoFragment;
import ymh.example.com.sanrennews.fragment.HomeDetailFragment.KejiFragment;
import ymh.example.com.sanrennews.fragment.HomeDetailFragment.MeinvFragment;
import ymh.example.com.sanrennews.fragment.HomeDetailFragment.TuijianFragment;
import ymh.example.com.sanrennews.fragment.HomeDetailFragment.YingshiFragment;
import ymh.example.com.sanrennews.utils.UrlUtils;

/**
 * Created by ymh on 2016/3/11.
 */
public class HomeFragment extends Fragment {
    Context context;
    LayoutInflater mlayoutInflater;
    private View view;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LinearLayout linear_layout;
    private ArrayList<BaseFragment> fragmentList;
    MyFragmentPagerAdapter myFragmentPagerAdapter;
    static ArrayList<String> titleContainer = new ArrayList<String>();

    public HomeFragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefragment_layout, container, false);
        findViews();
        initViewpager();
        return view;
    }

    private void findViews() {
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        linear_layout = (LinearLayout) view.findViewById(R.id.linear_layout);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initViewpager() {
        initTitle();
        fragmentList = new ArrayList<BaseFragment>();
        TuijianFragment tuijianFragment = new TuijianFragment(UrlUtils.YINGSHI_URL);
        GaoxiaoFragment gaoxiaoFragment = new GaoxiaoFragment(UrlUtils.GAOXIAO_URL);
        MeinvFragment meinvFragment = new MeinvFragment(UrlUtils.MEINV_URL);
        YingshiFragment yingshiFragment = new YingshiFragment(UrlUtils.YINGSHI_URL);
        KejiFragment kejiFragment = new KejiFragment(UrlUtils.KEJI_URL);
//        Fragment toutiaoFragment = new GaoxiaoFragment(UrlUtils.);

        fragmentList.add(tuijianFragment);
        fragmentList.add(gaoxiaoFragment);
        fragmentList.add(meinvFragment);
        fragmentList.add(yingshiFragment);
        fragmentList.add(kejiFragment);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleContainer);
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mViewPager.setCurrentItem(0);//设置当前显示标签页为第一页
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(myFragmentPagerAdapter);
    }


    private static void initTitle() {
        //页签项
        titleContainer.add("推荐");
        titleContainer.add("搞笑");
        titleContainer.add("风景");
        titleContainer.add("影视");
        titleContainer.add("科技");
    }

}

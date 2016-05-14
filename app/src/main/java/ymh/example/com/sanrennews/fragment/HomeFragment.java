package ymh.example.com.sanrennews.fragment;

import android.content.Context;
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
import ymh.example.com.sanrennews.fragment.homeDetailFragment.JingpinFragment;
import ymh.example.com.sanrennews.fragment.homeDetailFragment.QicheFragment;
import ymh.example.com.sanrennews.fragment.homeDetailFragment.TiyuFragment;
import ymh.example.com.sanrennews.fragment.homeDetailFragment.ZakerFragment;
import ymh.example.com.sanrennews.fragment.homeDetailFragment.RedianFragment;
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
    private ArrayList<Fragment> fragmentList;
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

    private void initViewpager() {
        initTitle();
        fragmentList = new ArrayList<Fragment>();
        RedianFragment redianFragment = new RedianFragment(UrlUtils.REDIAN_URL);
        ZakerFragment zakerFragment = new ZakerFragment(UrlUtils.ZAKER_URL);
        TiyuFragment tiyuFragment = new TiyuFragment(UrlUtils.TIYU_URL);
        QicheFragment qicheFragment = new QicheFragment(UrlUtils.QICHE_URL);
        JingpinFragment jingpinFragment = new JingpinFragment(UrlUtils.JINGPIN_URL);

        fragmentList.add(redianFragment);
        fragmentList.add(zakerFragment);
        fragmentList.add(tiyuFragment);
        fragmentList.add(qicheFragment);
        fragmentList.add(jingpinFragment);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleContainer);
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mViewPager.setCurrentItem(0);//设置当前显示标签页为第一页
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(myFragmentPagerAdapter);
    }


    private static void initTitle() {
        //页签项
        titleContainer.add("热点");
        titleContainer.add("关注");
        titleContainer.add("体育");
        titleContainer.add("汽车");
        titleContainer.add("精品");
    }
}

package ymh.example.com.sanrennews.adapter;

/**
 * Created by ymh on 2016/3/8.
 */

import java.util.ArrayList;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ymh.example.com.sanrennews.fragment.BaseFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<BaseFragment> list;
    ArrayList<String> titlelist;


    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragmentList, ArrayList<String> titleContainer) {
        super(fm);
        this.list = fragmentList;
        this.titlelist = titleContainer;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public BaseFragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}
package ymh.example.com.sanrennews.adapter;

/**
 * Created by ymh on 2016/3/8.
 */

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    ArrayList<String> titlelist;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> titlelist) {
        super(fm);
        this.list = list;
        this.titlelist = titlelist;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}

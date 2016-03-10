package ymh.example.com.sanrennews.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.adapter.MyFragmentPagerAdapter;
import ymh.example.com.sanrennews.fragment.GaoxiaoFragment;
import ymh.example.com.sanrennews.fragment.KejiFragment;
import ymh.example.com.sanrennews.fragment.LuntanFragment;
import ymh.example.com.sanrennews.fragment.MeinvFragment;
import ymh.example.com.sanrennews.fragment.ToutiaoFragment;
import ymh.example.com.sanrennews.fragment.TuijianFragment;
import ymh.example.com.sanrennews.fragment.YingshiFragment;
import ymh.example.com.sanrennews.utils.UrlUtils;

public class MainActivity extends AppCompatActivity {

    private long exitTime;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LinearLayout linear_layout;
    static ArrayList<String> titleContainer = new ArrayList<String>();
    private ArrayList<Fragment> fragmentList;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViewpager();
    }

    private void findViews() {

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        linear_layout = (LinearLayout) findViewById(R.id.linear_layout);
    }


    private void initViewpager() {
        initTitle();
        fragmentList = new ArrayList<Fragment>();
        Fragment tuijianFragment = new TuijianFragment(UrlUtils.GAOXIAO_URL);
        Fragment gaoxiaoFragment = new GaoxiaoFragment(UrlUtils.GAOXIAO_URL);
        Fragment meinvFragment = new MeinvFragment(UrlUtils.MEINV_URL);
        Fragment yingshiFragment = new YingshiFragment(UrlUtils.YINGSHI_URL);
        Fragment kejiFragment = new KejiFragment(UrlUtils.KEJI_URL);
//        Fragment toutiaoFragment = new GaoxiaoFragment(UrlUtils.);

        fragmentList.add(tuijianFragment);
        fragmentList.add(gaoxiaoFragment);
        fragmentList.add(meinvFragment);
        fragmentList.add(yingshiFragment);
        fragmentList.add(kejiFragment);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titleContainer);
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mViewPager.setCurrentItem(0);//设置当前显示标签页为第一页
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(myFragmentPagerAdapter);

    }


    private static void initTitle() {
        //页签项
        titleContainer.add("推荐");
        titleContainer.add("搞笑");
        titleContainer.add("美女");
        titleContainer.add("影视");
        titleContainer.add("科技");
//        titleContainer.add("搞笑");
//        titleContainer.add("焦点");
//        titleContainer.add("影视");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

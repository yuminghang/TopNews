package ymh.example.com.sanrennews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.fragment.DongtuFragment;
import ymh.example.com.sanrennews.fragment.HomeFragment;
import ymh.example.com.sanrennews.fragment.FaxianFragment;
import ymh.example.com.sanrennews.service.PushService;
import ymh.example.com.sanrennews.utils.UrlUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private long exitTime;

    FrameLayout fragment_container;
    HomeFragment homeFragment;
    FaxianFragment faxianFragment;
    DongtuFragment dongtuFragment;
    RadioButton btn_home, btn_dongtu, btn_faxian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, PushService.class));
        // create our manager instance after the content view is set
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        // enable status bar tint
//        tintManager.setStatusBarTintEnabled(true);
//        // enable navigation bar tint
//        tintManager.setNavigationBarTintEnabled(true);
//        tintManager.setTintColor(R.color.title_color);
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        initRadioButton();
        select(0);
    }

    private void select(int i) {
        FragmentManager fm = getSupportFragmentManager();  //获得Fragment管理器
        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

        hidtFragment(ft);   //先隐藏 Fragment

        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment(this);
                    ft.replace(R.id.fragment_container, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (dongtuFragment == null) {
                    dongtuFragment = new DongtuFragment(this);
                    ft.add(R.id.fragment_container, dongtuFragment);
                } else {
                    ft.show(dongtuFragment);
                }
                break;
            case 2:
                if (faxianFragment == null) {
                    faxianFragment = new FaxianFragment(UrlUtils.NEIHAN_URL);
                    ft.add(R.id.fragment_container, faxianFragment);
                } else {
                    ft.show(faxianFragment);
                }
                break;
        }
        ft.commit();   //提交事务
    }

    //隐藏所有Fragment
    private void hidtFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (dongtuFragment != null) {
            fragmentTransaction.hide(dongtuFragment);
        }
        if (faxianFragment != null) {
            fragmentTransaction.hide(faxianFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                select(0);
                break;
            case R.id.btn_dongtu:
                select(1);
                break;
            case R.id.btn_faxian:
                select(2);
                break;
        }
    }

    private void initRadioButton() {
        btn_home = (RadioButton) findViewById(R.id.btn_home);
        btn_dongtu = (RadioButton) findViewById(R.id.btn_dongtu);
        btn_faxian = (RadioButton) findViewById(R.id.btn_faxian);
        btn_home.setOnClickListener(this);
        btn_dongtu.setOnClickListener(this);
        btn_faxian.setOnClickListener(this);
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

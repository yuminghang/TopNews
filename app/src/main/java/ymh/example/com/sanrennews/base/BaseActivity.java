package ymh.example.com.sanrennews.base;

import android.os.Bundle;
import android.view.Window;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import ymh.example.com.sanrennews.MyApplication;

public abstract class BaseActivity extends SwipeBackActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addActivity(this);
    }

}
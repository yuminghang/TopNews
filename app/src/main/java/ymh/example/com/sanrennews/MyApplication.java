package ymh.example.com.sanrennews;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymh on 2016/5/13.
 */

public class MyApplication extends Application {
    private static List<Activity> activities = new ArrayList<Activity>();
    private static MyApplication myApplication = new MyApplication();

    public MyApplication() {

    }


    public static MyApplication getInstance() {
        return myApplication;
    }

    public void exit() {
        try {
            for (Activity activity : activities) {
                if (!activity.isFinishing() && activity != null) {
                    activity.finish();
                }
            }
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {

        }

    }

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void closeAllActivity() {
        for (Activity activity1 : activities) {
            if (!activity1.isFinishing() && activity1 != null) {
                activity1.finish();
            }
        }
    }

}

package ymh.example.com.sanrennews.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.webkit.WebView;


import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Random;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.ui.WebviewActivity;
import ymh.example.com.sanrennews.ui.YiDianWebActivity;


/**
 * Created by deng on 16-3-13.
 */
public class PushService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private Socket mSocket;
    private NotificationManager mNotifMan;


    {
        try {
            mSocket = IO.socket("http://120.27.41.245:3002/");
        } catch (URISyntaxException e) {
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences userType = getSharedPreferences("userType", MODE_PRIVATE);
        int myType = userType.getInt("myType", 1);
        for (int i = 0; i < 20; i++) {
            int nu = myType & (int) Math.pow(2, i);
            if (nu > 0) {
                mSocket.on("type" + i, onPushMessage);
            }
        }


        mSocket.connect();
        mNotifMan = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

    }


    private Emitter.Listener onPushMessage = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if (isTooQuick()) {
                return;
            }
            String arg = (String) args[0];
            JSONObject jsonObject;
            try {
                jsonObject=new JSONObject(arg);
                String title = jsonObject.getString("title");
                String date = jsonObject.getString("date");
                String url = jsonObject.getString("url");

                System.out.println("++++++++++" + title +
                        "+++++++++++++" + date +
                        "+++++++++++++");
                mNtify(title,date,url);
            } catch (JSONException e) {
                e.printStackTrace();
            }





        }


    };


    private void mNtify(String title, String date, String url) {
//        if (isTooQuick()) {
//            return;
//        }
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.setClass(this, YiDianWebActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                intent, 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.pic_default)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(title))
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setContentTitle(title)
                        .setContentText(date);

        mBuilder.setContentIntent(contentIntent);
        int i = new Random().nextInt(100);
        mNotifMan.notify(i, mBuilder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);

    }

    private static long lastClickTime;

    public synchronized static boolean isTooQuick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}

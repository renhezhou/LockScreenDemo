package rxh.hb.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import rxh.hb.activity.MainActivity;
import rxh.hb.service.LockService;

/**
 * Created by Administrator on 2016-05-04.
 */
public class LockScreenBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //开机启动广播
        context.startService(new Intent(context, LockService.class));
        Intent i = new Intent(context, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}

package rxh.hb.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import rxh.hb.activity.MainActivity;

/**
 * Created by Administrator on 2016-05-04.
 */
public class LockScreenBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Intent intent1 = new Intent();
            intent1.setClass(context, MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}

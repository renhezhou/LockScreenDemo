package rxh.hb.activity;

import android.app.KeyguardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import rxh.hb.service.LockService;

public class MainActivity extends AppCompatActivity {

    private static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    private TextView tv;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);//android4.0以后用来屏蔽home键
        KeyguardManager manager = (KeyguardManager) this.getSystemService(this.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock keyguardLock = manager.newKeyguardLock("");
        keyguardLock.disableKeyguard();//关闭系统的锁屏
        setContentView(R.layout.activity_main);
        initview();
        startService(new Intent(getApplicationContext(), LockService.class));
    }

    public void initview() {
        img = (ImageView) findViewById(R.id.img);
        Glide
                .with(getApplicationContext())
                .load("")
                .centerCrop()
                .placeholder(R.mipmap.gif)
                .crossFade()
                .into(img);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //setFlag，可以捕获了home键，然后不继续分发下去，让其他的程序不能捕获到home键的按下事件和长按事件，如果不想屏蔽home键，长按home键，那么可以返回false分发下去，或者清除flag不再捕获home键
        return true;
    }

}

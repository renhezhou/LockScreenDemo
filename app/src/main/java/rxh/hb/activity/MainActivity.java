package rxh.hb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import lib.lhh.fiv.library.FrescoZoomImageView;

public class MainActivity extends AppCompatActivity {

    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    private TextView tv;
    private FrescoZoomImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
        setContentView(R.layout.activity_main);
        initview();
    }

    public void initview() {
        img = (FrescoZoomImageView) findViewById(R.id.img);
        img.loadLocalImage(null, R.mipmap.gif);
        tv= (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

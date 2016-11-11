package com.example.li.left;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton left;
    private ImageButton right;
    private ImageButton start;
    private PlayThread playThread;
    private HeadsetPlugReceiver headsetPlugReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerHeadsetPlugReceiver();

        left = (ImageButton) findViewById(R.id.leftear);
        right = (ImageButton) findViewById(R.id.rightear);
        start = (ImageButton) findViewById(R.id.start);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是左耳", Toast.LENGTH_SHORT).show();
                if (null != playThread) {
                    playThread.setChannel(true, false);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是右耳", Toast.LENGTH_SHORT).show();
                if (null != playThread) {
                    playThread.setChannel(false, true);
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "开始播放", Toast.LENGTH_SHORT).show();
                if (null != playThread) {
                    playThread.stopp();
                    playThread = null;
                }
                playThread = new PlayThread(MainActivity.this, "tts1.pcm");
                playThread.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(headsetPlugReceiver);
        super.onDestroy();
    }

    private void registerHeadsetPlugReceiver() {
        headsetPlugReceiver = new HeadsetPlugReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(headsetPlugReceiver, intentFilter);
    }
}

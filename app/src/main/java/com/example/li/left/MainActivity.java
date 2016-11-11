package com.example.li.left;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button left;
    private Button right;
    private Button start;
    private PlayThread playThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button) findViewById(R.id.leftear);
        right = (Button) findViewById(R.id.rightear);
        start = (Button) findViewById(R.id.start);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != playThread) {
                    playThread.setChannel(true, false);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != playThread) {
                    playThread.setChannel(false, true);
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != playThread) {
                    playThread.stopp();
                    playThread = null;
                }
                playThread = new PlayThread(MainActivity.this, "tts1.pcm");
                playThread.start();
            }
        });
    }
}

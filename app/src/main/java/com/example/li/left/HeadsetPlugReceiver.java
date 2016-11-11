package com.example.li.left;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Li on 2016/11/11 0011.
 */

public class HeadsetPlugReceiver extends BroadcastReceiver {

    private static final String TAG = "HeadsetPlugReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("state")){
            if (intent.getIntExtra("state", 0) == 0){
                Toast.makeText(context, "请插入耳机", Toast.LENGTH_LONG).show();
            }
            else if (intent.getIntExtra("state", 0) == 1){
                Toast.makeText(context, "耳机已插入", Toast.LENGTH_LONG).show();
            }
        }
    }
}

package com.als.sendbroadcast;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendOutBroadcast(View view) {
        Intent testIntent = new Intent();
        testIntent.setAction("com.als.sendbroadcast");
//        testIntent.setClassName("com.als.receivebroadcast", ".ReceiveBroadcast");
        testIntent.setComponent(new ComponentName("com.als.receivebroadcast", "com.als.receivebroadcast.ReceiveBroadcast"));
        testIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        Log.d(TAG, "send testing intent");
        sendBroadcast(testIntent);
        Toast toast = Toast.makeText(this.getApplicationContext(), "action:" + testIntent.getAction(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

}

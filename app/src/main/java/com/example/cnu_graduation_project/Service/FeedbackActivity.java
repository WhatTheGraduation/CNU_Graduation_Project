package com.example.cnu_graduation_project.Service;

import static com.example.cnu_graduation_project.TaskTag.ACTIVITY_TAG;
import static com.example.cnu_graduation_project.TaskTag.WINDOW_ON;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.cnu_graduation_project.DrivingRecognitionActivity;
import com.example.cnu_graduation_project.Lock.LockReceiver;

import java.util.Timer;
import java.util.TimerTask;

public class FeedbackActivity extends DrivingRecognitionActivity {

    String TAG="FeedbackActibity";
    Vibrator vibrator;
    public Timer timer = new Timer();
    public TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if(WINDOW_ON&&ACTIVITY_TAG)
                vibrator.vibrate(500);
            Log.d(TAG,"vibration");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Create");
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void startVibration(){
        timer.schedule(task,0,1000);
    }

    public void stopVibration(){
        timer.cancel();
    }

}

package com.droidmarvin.peripheraliointerfacingzxgesturesensorusinguartzxgesturesensordriver;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.things.contrib.driver.zxgesturesensor.ZXGestureSensor;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final String ZX_GESTURE_SENSOR = "UART0";

    private static final String TAG = MainActivity.class.getSimpleName();

    private ZXGestureSensor mZxSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mZxGestureSetup();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyZxGesture();
    }

    // Access the Gesture sensor and listen for gesture event
    private void mZxGestureSetup(){

        try {
            mZxSensor = ZXGestureSensor.getUartSensor(ZX_GESTURE_SENSOR, new Handler());
            mZxSensor.setListener(new ZXGestureSensor.OnGestureEventListener() {
                @Override
                public void onGestureEvent(ZXGestureSensor sensor, ZXGestureSensor.Gesture gesture, int param) {
                    // do something awesome
                }
            });
        }catch (IOException e){
            // couldn't configure the sensor...
        }
    }

    // Close the sensor when finished
    private void destroyZxGesture() {
        if (mZxSensor != null) {
            try {
                mZxSensor.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing ZXGestureSensor", e);
            } finally {
                mZxSensor = null;
            }
        }
    }



}

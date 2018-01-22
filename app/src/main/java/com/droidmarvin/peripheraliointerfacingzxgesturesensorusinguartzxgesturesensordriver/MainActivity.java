package com.droidmarvin.peripheraliointerfacingzxgesturesensorusinguartzxgesturesensordriver;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.things.contrib.driver.zxgesturesensor.ZXGestureSensor;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final String ZX_GESTURE_SENSOR = "UART0";

    private static final String TAG = MainActivity.class.getSimpleName();

    private ZXGestureSensor mZxSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    // Access the Gesture sensor and listen for gesture event
    private void mmZxGestureSetup(){

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



}

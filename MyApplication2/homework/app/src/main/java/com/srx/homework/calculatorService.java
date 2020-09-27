package com.srx.homework;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class calculatorService extends Service {
    public calculatorService() {
    }

    class MyBinder extends Binder {
        public double callService(String num1, String num2, String sign) {
            Log.d("TAG", "callService:被调用了 ");
            return calculatorServices(num1, num2, sign);
        }
    }

    private double calculatorServices(String num1, String num2, String sign) {
        Log.d("TAG", "calculatorServices:被调用了 ");
        if (sign.equals("+")) {
            return Double.parseDouble(num1) + Double.parseDouble(num2);
        } else if (sign.equals("-")) {
            return Double.parseDouble(num1) - Double.parseDouble(num2);
        } else if (sign.equals("/")) {
            return Double.parseDouble(num1) / Double.parseDouble(num2);
        } else if (sign.equals("*")) {
            return Double.parseDouble(num1) * Double.parseDouble(num2);
        } else
            return 0;
    }

    @Override
    public void onCreate() {
        Log.d("TAG", "onCreate:被调用了 ");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG", "onBind:被调用了 ");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TAG", "unbindService:被调用了 ");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.d("TAG", "onDestroy:被调用了 ");
        super.onDestroy();
    }

}

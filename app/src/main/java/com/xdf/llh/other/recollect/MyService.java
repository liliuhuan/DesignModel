package com.xdf.llh.other.recollect;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.xdf.llh.designdemo.TestData;

import aidl.AidlService;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     * 本地服务 继承 binder
     * 远程服务 继承 Aidl.Stub
     */
    public static class MyBinder extends AidlService.Stub {
        @Override
        public String getString() {
            Log.d("ServiceTest", "  ----->  getString");
            return "test one time";
        }

        @Override
        public TestData getData() throws RemoteException {
            TestData testData = new TestData("张三1","1");
            return testData;
        }
    }
}

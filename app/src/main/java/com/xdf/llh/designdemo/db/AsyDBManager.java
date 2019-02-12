package com.xdf.llh.designdemo.db;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * author: 李刘欢
 * date：2019/2/12 16:11
 * version:1.0.0
 * description: AsyDBManager 异步操作数据库
 */
public abstract class AsyDBManager<T> {
    private static ExecutorService sDbEngine = Executors.newSingleThreadExecutor();
    private final static Handler mUIHandle = new Handler(Looper.getMainLooper());
    /**
     * 执行线程池操作
     */
    public final void execute() {
        sDbEngine.execute(new Runnable() {
            @Override
            public void run() {
                postResult(doInBackground());
            }
        });
    }

    /** 去投递结果
     * @param t
     */
    private void postResult(final T t) {
        mUIHandle.post(new Runnable() {
            @Override
            public void run() {
                onPostExecute(t);
            }
        });
    }

    /** 后台的数据库操作
     * @return
     */
    protected abstract T doInBackground();

    /** 投递到主线程
     * @param result
     */
    protected void onPostExecute(T result) {
    }
}

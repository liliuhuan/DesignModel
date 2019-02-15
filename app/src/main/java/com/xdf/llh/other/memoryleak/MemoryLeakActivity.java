package com.xdf.llh.other.memoryleak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xdf.llh.designdemo.R;

import java.lang.ref.WeakReference;

/**
 * 内存泄漏  静态内部类，持有外部引用时用弱引用，当页面销毁时，同样内部类的持有对象就会回收）
 * <p>
 * {@link android.widget.Toast } 持有application 的上下文引用
 * 常用的文件流{@link java.io.FileOutputStream,java.io.BufferedInputStream,java.io.BufferedReader,android.database.Cursor } 等用完后就{close}
 * {@link android.graphics.Bitmap,android.util.TypedValue } 用完结束后recycle()
 */
public class MemoryLeakActivity extends AppCompatActivity {
    CustomHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);
        handler = new CustomHandler(this);

        new Button(this).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2019/2/15  handler操作数据
                Message message = Message.obtain();
                message.what = 1;
                message.obj = "111";
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 弱引用内存泄漏问题
     */
    static class CustomHandler extends Handler {
        private WeakReference<MemoryLeakActivity> weakReference;

        public CustomHandler(MemoryLeakActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (weakReference == null) {
                return;
            }
            MemoryLeakActivity graffitiActivity = weakReference.get();
            if (graffitiActivity != null) {
                switch (msg.what) {
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 移除handle中的回调和消息，防止内存泄漏
         */
        handler.removeCallbacksAndMessages(null);
    }
}

package com.xdf.llh.other.thead;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.xdf.llh.designdemo.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: 李刘欢
 * @CreateDate: 2019/2/26 11:26
 * @Version: 1.0.0
 * @Description: 它本质是一种特殊的Service, 继承自Service并且本身就是一个抽象类
 * 它可以用于在后台执行耗时的异步任务，当任务完成后会自动停止
 * 它拥有较高的优先级，不易被系统杀死（继承自Service的缘故），因此比较适合执行一些高优先级的异步任务
 * 它内部通过HandlerThread和Handler实现异步操作
 * 创建IntentService时，只需实现onHandleIntent和构造方法，onHandleIntent为异步方法，可以执行耗时操作
 */
public class IntentServiceActivity extends AppCompatActivity {
    /**
     * 图片地址集合
     */
    private String url[] = {
            "https://img-blog.csdn.net/20160903083245762",
            "https://img-blog.csdn.net/20160903083252184",
            "https://img-blog.csdn.net/20160903083257871",
            "https://img-blog.csdn.net/20160903083257871",
            "https://img-blog.csdn.net/20160903083311972",
            "https://img-blog.csdn.net/20160903083319668",
            "https://img-blog.csdn.net/20160903083326871"
    };

    private static ImageView imageView;
    @SuppressLint("HandlerLeak")
    private static final Handler mUIHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            imageView.setImageBitmap((Bitmap) msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_thread);
        imageView = findViewById(R.id.image);
        Intent intent = new Intent(this,MyIntentService.class);
        for (int i=0;i<7;i++) {//循环启动任务
            intent.putExtra(MyIntentService.DOWNLOAD_URL,url[i]);
            intent.putExtra(MyIntentService.INDEX_FLAG,i);
            startService(intent);
        }
//        new AsyncTask<String,Void,Bitmap>().execute("URL");
    }

    /**
     * 需要清单文件注册
     */
    public class MyIntentService extends IntentService {
        public static final String DOWNLOAD_URL = "download_url";
        public static final String INDEX_FLAG = "index_flag";
        public  UpdateUI updateUI;


        public void setUpdateUI(UpdateUI updateUIInterface) {
            updateUI = updateUIInterface;
        }

        public MyIntentService() {
            super("MyIntentService");
        }

        /**
         * Creates an IntentService.  Invoked by your subclass's constructor.
         *
         * @param name Used to name the worker thread, important only for debugging.
         */
        public MyIntentService(String name) {
            super(name);
        }

        @Override
        protected void onHandleIntent(@Nullable Intent intent) {
            //在子线程中进行网络请求
            Bitmap bitmap = downloadUrlBitmap(intent.getStringExtra(DOWNLOAD_URL));
            Message msg1 = new Message();
            msg1.what = intent.getIntExtra(INDEX_FLAG, 0);
            msg1.obj = bitmap;
            //通知主线程去更新UI
//            if (updateUI != null) {
//                updateUI.updateUI(msg1);
//            }
             mUIHandler.sendMessageDelayed(msg1,1000);
        }

        private Bitmap downloadUrlBitmap(String urlString) {
            HttpURLConnection urlConnection = null;
            BufferedInputStream in = null;
            Bitmap bitmap = null;
            try {
                final URL url = new URL(urlString);
                urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream(), 8 * 1024);
                bitmap = BitmapFactory.decodeStream(in);
            } catch (final IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }

    }

    public interface UpdateUI {
        void updateUI(Message message);
    }
}

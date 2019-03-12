package com.xdf.llh.designdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdf.llh.other.recollect.MyService;

import aidl.AidlService;

/**
 * @author dell
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("title", "zhangshan");
//            jsonObject.put("id", 2);
//            Logger.loge(jsonObject.toString());
//            TestData testData = new Gson().fromJson(jsonObject.toString(), TestData.class);
//            Logger.loge(testData.toString());
//        } catch (Exception e) {
//            Logger.loge(e.getMessage());
//        }
        /**
         * 一般工厂模式
         */
//        new com.xdf.llh.designdemo.simple_factory.impl.FactoryCreator().createManyFactory();
        /**
         * 抽象工厂模式
         */
//        new com.xdf.llh.designdemo.abstract_factory.impl.FactoryCreator().createHuman();

        /**
         * 简单的builder模式
         */
        //   new Product.Builder().setTitle("止咳糖浆").setDes("专治小儿咳嗽，哮喘等引起的一系列问题！").build().printProduct();
        /**
         * 简单的动态代理
         */
        //   new ProxyRun().proxyRun4();

        /**
         * 观察者模式
         */
        //   new ObserverCreator().crate();
        /**
         * 适配器模式
         */
      //  new AdapterCreator().create();

        /***
         * 数据库操作部分
         */
//
//        final StudentTable studentTable = SQLiteDBHelper.newInstance(this).getStudentTable();
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                studentTable.insertData(new StudentBean(1, "stu-name+1", "ss"));
//            }
//        });
//        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                studentTable.deleteData(new StudentBean(1, "", ""));
//            }
//        });
//        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                studentTable.updateData(new StudentBean(1, "stu-name+2", "ss2"));
//            }
//        });
//        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                StudentBean studentBean = studentTable.queryByFilter("1");
//                if (studentBean != null)
//                    Logger.loge(studentBean.toString());
//            }
//        });
//        new AsyDBManager<BaseBean>() {
//            @Override
//            protected BaseBean doInBackground() {
//                // TODO: 2019/2/12  数据库查询操作
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(BaseBean result) {
//                super.onPostExecute(result);
//                // TODO: 2019/2/12 查询的结果
//            }
//        }.execute();
//
//        new AsyDBManager<Void>() {
//            @Override
//            protected Void doInBackground() {
//                return null;
//            }
//        }.execute();
//
//        ThreadManager.getSinglePool().execute(new Runnable() {
//            @Override
//            public void run() {
//                studentTable.updateData(new StudentBean(1, "stu-name+2", "ss2"));
//            }
//        });

      //  ((TextView) findViewById(R.id.tv)).setText("输入的字符是：\nA1,A2,S2,E1,R4,E2,E3,R5,S3,S4  \n输出字符：\n" + Test.check("A1,A2,S2,E1,R4,E2,E3,R5,S3,S4"));

        /**
         * 本地服务
         */
          //bindLocalService();
        /**
         * 远程服务 -- AIDL  AIDL（Android Interface Definition Language）是Android接口定义语言的意思，它可以用于让某个Service与多个应用程序组件之间进行跨进程通信，从而可以实现多个应用程序共享同一个Service的功能
         */
        bindRemoteService();
    }

    private void bindRemoteService() {
        bindService(new Intent(this, MyService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                AidlService  binder = AidlService.Stub.asInterface(service);
                try {
                    Logger.loge("\n getString - >" + binder.getString() + "\n" + "getData - > " + binder.getData().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
             //   binder = null;
            }
        }, BIND_AUTO_CREATE);
    }

    private void bindLocalService() {
        bindService(new Intent(this, MyService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder  binder = (MyService.MyBinder) service;
                try {
                    Logger.loge("\n getString - >" + binder.getString() + "\n" + "getData - > " + binder.getData().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }
}

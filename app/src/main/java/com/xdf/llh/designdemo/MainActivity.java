package com.xdf.llh.designdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xdf.llh.designdemo.adapter.AdapterCreator;
import com.xdf.llh.designdemo.db.AsyDBManager;
import com.xdf.llh.designdemo.db.BaseBean;
import com.xdf.llh.designdemo.db.SQLiteDBHelper;
import com.xdf.llh.designdemo.db.StudentBean;
import com.xdf.llh.designdemo.db.StudentTable;
import com.xdf.llh.designdemo.db.ThreadManager;

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
        new AdapterCreator().create();

/***
 * 数据库操作部分
 */

        final StudentTable studentTable = SQLiteDBHelper.newInstance(this).getStudentTable();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentTable.insertData(new StudentBean(1, "stu-name+1", "ss"));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentTable.deleteData(new StudentBean(1, "", ""));
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentTable.updateData(new StudentBean(1, "stu-name+2", "ss2"));
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentBean studentBean = studentTable.queryByFilter("1");
                if (studentBean != null)
                    Logger.loge(studentBean.toString());
            }
        });
        new AsyDBManager<BaseBean>() {
            @Override
            protected BaseBean doInBackground() {
                // TODO: 2019/2/12  数据库查询操作
                return null;
            }

            @Override
            protected void onPostExecute(BaseBean result) {
                super.onPostExecute(result);
                // TODO: 2019/2/12 查询的结果
            }
        }.execute();

        new AsyDBManager<Void>() {
            @Override
            protected Void doInBackground() {
                return null;
            }
        }.execute();

        ThreadManager.getSinglePool().execute(new Runnable() {
            @Override
            public void run() {
                studentTable.updateData(new StudentBean(1, "stu-name+2", "ss2"));
            }
        });
    }
}

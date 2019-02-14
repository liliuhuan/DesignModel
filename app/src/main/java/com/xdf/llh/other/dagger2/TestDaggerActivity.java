package com.xdf.llh.other.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdf.llh.designdemo.Logger;
import com.xdf.llh.designdemo.R;

import javax.inject.Inject;

public class TestDaggerActivity extends AppCompatActivity {
    @Inject
    UserBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dagger);
        DaggerActivityComponent
                .builder()
                .applicationComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule())
                .build()
                .inject(this);
        userBean.setId(1);
        Logger.loge(userBean.toString());
    }
}

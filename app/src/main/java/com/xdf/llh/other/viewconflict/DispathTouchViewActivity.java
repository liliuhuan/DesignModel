package com.xdf.llh.other.viewconflict;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xdf.llh.designdemo.R;
import com.xdf.llh.other.recollect.TestEnum;
import com.xdf.llh.other.recollect.annotation.AnnotateUtils;
import com.xdf.llh.other.recollect.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决 View 之间的滑动冲突的方法
 */
public class DispathTouchViewActivity extends AppCompatActivity {

    private List<View> viewList;
    @ViewInject(value = R.id.viewPager)
    private InsideViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispath_touch_view);
        AnnotateUtils.injectViews(this);

        viewList = new ArrayList<>();
        initData(true);
        viewPager.setAdapter(new MyPagerAdapter(viewList));
        new TestEnum();
    }

    private void initData(boolean flag) {
        for (int j = 0; j < 4; j++) {
            View view;
            if (flag) {
                ListView listView = new InsideListView(this);
                List<String> dataList = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    dataList.add("leavesC " + i);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
                listView.setAdapter(adapter);
                view = listView;
            } else {
                TextView textView = new TextView(this);
                textView.setGravity(Gravity.CENTER);
                textView.setText("leavesC " + j);
                view = textView;
            }
            viewList.add(view);
        }
    }
}

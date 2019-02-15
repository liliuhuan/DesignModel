package com.xdf.llh.other.viewconflict;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author: 李刘欢
 * date：2019/2/15 14:42
 * version:1.0.0
 * description: InsideViewPager
 */
public class InsideViewPager extends ViewPager {
    public InsideViewPager(@NonNull Context context) {
        super(context);
    }

    public InsideViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getAction() & MotionEvent.ACTION_MASK;
//        if (action == MotionEvent.ACTION_DOWN) {
//            super.onInterceptTouchEvent(ev);
//            return false;
//        }
        return  super.onInterceptTouchEvent(ev);
    }
}

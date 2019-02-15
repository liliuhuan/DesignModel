package com.xdf.llh.other.viewconflict;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author: 李刘欢
 * date：2019/2/15 14:40
 * version:1.0.0
 * description: MyViewPager   通过外部拦截法解决滑动冲突
 */
public class OutViewPager extends ViewPager {
    public OutViewPager(@NonNull Context context) {
        super(context);
    }
    public OutViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private int lastXIntercept;

    private int lastYIntercept;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        final int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //不拦截此事件
                intercepted = false;
                //调用 ViewPager的 onInterceptTouchEvent 方法用于初始化 mActivePointerId
                super.onInterceptTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                //横向位移增量
                int deltaX = x - lastXIntercept;
                //竖向位移增量
                int deltaY = y - lastYIntercept;
                //如果横向滑动距离大于竖向滑动距离，则认为使用者是想要左右滑动
                //此时就使 ViewPager 拦截此事件
                intercepted = Math.abs(deltaX) > Math.abs(deltaY);
                break;
            case MotionEvent.ACTION_UP:
                //不拦截此事件
                intercepted = false;
                break;
            default:
                break;
        }
        lastXIntercept = x;
        lastYIntercept = y;
        return intercepted;
    }

}

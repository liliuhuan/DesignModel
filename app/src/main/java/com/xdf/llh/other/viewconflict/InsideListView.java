package com.xdf.llh.other.viewconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * author: 李刘欢
 * date：2019/2/15 14:41
 * version:1.0.0
 * description: MyListView   通过内部拦截法解决滑动冲突
 */
public class InsideListView extends ListView {
    public InsideListView(Context context) {
        super(context);
    }

    public InsideListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int lastX;

    private int lastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        final int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                /**
                 * true 父类不拦截 false 父类拦截
                 */
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                //横向位移增量
                int deltaX = x - lastX;
                //竖向位移增量
                int deltaY = y - lastY;
                //如果横向滑动距离大于竖向滑动距离，则认为使用者是想要左右滑动
                //此时就通知父容器 ViewPager 处理此事件
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    /**
                     * true 父类不拦截 false 父类拦截
                     */
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        lastX = x;
        lastY = y;
        return super.dispatchTouchEvent(ev);
    }

}

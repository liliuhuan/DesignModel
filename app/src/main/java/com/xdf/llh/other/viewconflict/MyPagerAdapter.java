package com.xdf.llh.other.viewconflict;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * author: 李刘欢
 * date：2019/2/15 14:39
 * version:1.0.0
 * description: MyPagerAdapter
 */
public class MyPagerAdapter extends PagerAdapter {
    List<View> views;

    public MyPagerAdapter(List<View> viewList) {
        this.views = viewList;
    }

    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //  super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }
}

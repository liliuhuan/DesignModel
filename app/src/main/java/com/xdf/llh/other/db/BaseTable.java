package com.xdf.llh.other.db;

import java.util.List;

/**
 * author: 李刘欢
 * date：2019/2/12 15:02
 * version:1.0.0
 * description: BaseTable
 */
public interface BaseTable<T extends BaseBean> {
    /**
     * 增
     * @param item
     * @return
     */
    long insertData(T item);

    /**
     * 删
     * @param item
     * @return
     */
    int deleteData(T item);

    /**
     * 改
     * @param item
     * @return
     */
    long updateData(T item);

    /**
     * 查
     * @return
     */
    List<T> queryAllData();

    /**
     * 单条查询
     * @param sId
     * @return
     */
    T queryByFilter(String sId);
}

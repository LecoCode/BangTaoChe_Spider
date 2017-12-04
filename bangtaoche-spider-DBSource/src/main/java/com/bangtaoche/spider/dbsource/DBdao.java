package com.bangtaoche.spider.dbsource;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public interface DBdao {
    /**
     * 通过id获取车辆
     * @param id
     */
    void getByID(long id);
    /**
     * 通过车的url获取车辆
     * @param urlName
     */
    void getByName(String urlName);
    /**
     * 获取上新的车
     * status=1
     */
    void getStatus();
    /**
     * 通过一个id的数组获取所有字段数据
     * @param ids
     */
    void getListByID(long [] ids);


}

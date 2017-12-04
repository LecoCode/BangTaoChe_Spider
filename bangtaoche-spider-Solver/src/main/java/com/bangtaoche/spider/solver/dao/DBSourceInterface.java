package com.bangtaoche.spider.solver.dao;

import com.bangtaoche.spider.solver.entity.Che168Car;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
//下架、上新、取消上新、降价、取消降价
public interface DBSourceInterface {
    /**
     * 查询是否存在
     * @param carUrl 车的url
     * @return
     */
    boolean isCarExist(String carUrl);
    /**
     * 查询上新状态
     * @param carUrl 车的url
     * @return
     */
    String isCarNews(String carUrl);
    /**
     * 查询价钱
     * @param carUrl 车的url
     * @return
     */
    String isCarPrice(String carUrl);
    //-------------------------------
    /**
     * 上新
     * @param che168Car
     * @return 是否成功
     */
    long Insert(Che168Car che168Car);
    /**
     * 修改是否上新、是否降价、是否下架 字段的值
     * @param che168Car
     * @return是否成功
     */
    long Update(Che168Car che168Car);
    /**
     * 删除车辆
     * @param carUrl
     * @return
     */
    long Delete(String carUrl);
}

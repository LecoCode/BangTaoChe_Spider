package com.bangtaoche.spider.solver.dao;

import com.bangtaoche.spider.solver.entity.Che168Car;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSource implements DBSourceInterface {
    private String fromName;
    /**
     * @param fromName 表名
     */
    public DBSource(String fromName){
        this.fromName=fromName;
    }


    public boolean isCarExist(String carUrl) {
        return false;
    }

    public String isCarNews(String carUrl) {
        return null;
    }

    public String isCarPrice(String carUrl) {
        return null;
    }

    public long Insert(Che168Car che168Car) {
        return 0;
    }

    public long Update(Che168Car che168Car) {
        return 0;
    }

    public long Delete(String carUrl) {
        return 0;
    }
}

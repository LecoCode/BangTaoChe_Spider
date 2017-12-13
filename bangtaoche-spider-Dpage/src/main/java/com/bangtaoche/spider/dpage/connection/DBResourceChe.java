package com.bangtaoche.spider.dpage.connection;

import bangtaoche.spider.beans.data.DBSourceConfig;
import com.bangtaoche.spider.dbsource.DBSourcePool;
import com.bangtaoche.spider.dbsource.DBSourceimpl;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBResourceChe {
    private static  DBSourcePool dbSourceimpl;
   public static void ini(){
       DBSourceConfig dbConfig = DpageCoordinator.dpageConfig.getDbSourceConfig();
       DBSourceConfig dbSourceConfig = new DBSourceConfig();
        dbSourceConfig.setDriverClassName(dbConfig.getDriverClassName());
        dbSourceConfig.setUrl(dbConfig.getUrl());
        dbSourceConfig.setUsername(dbConfig.getUsername());
        dbSourceConfig.setPassword(dbConfig.getPassword());
        dbSourceimpl = new DBSourcePool(dbSourceConfig);
   }

    public static DBSourceimpl getDbSourceimpl() {
        DBSourceimpl sourceimpl = dbSourceimpl.getSourceimpl();
        return sourceimpl;
    }
}

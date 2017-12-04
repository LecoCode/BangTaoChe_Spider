package com.bangtaoche.spider.dbsource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceStatement {
    private String fromName;
    public DBSourceStatement(String fromName){
        this.fromName=fromName;
    }
    //创建查询
    private PreparedStatement createStatement(String sql){
        PreparedStatement preparedStatement=null;
        try {
            Connection conn = DBSourceConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
    //底层查询
    protected PreparedStatement getByAll(String field,String wheres){
        String tsField = "*";
        String tsWheres = "";
        if (field!=null&&!"".equals(field)){
            tsField=field;
        }if (wheres!=null&&!"".equals(wheres)){
            tsWheres=wheres;
        }
        String sql ="SELECT"+tsField+"FROM"+fromName+"WHERE"+tsWheres;;
        PreparedStatement statement = createStatement(sql);
        return statement;
    }

    //查询字段
    protected PreparedStatement getByfield(String field){
        String tsField="";
        if (field!=null&&!"".equals(field))
            tsField=field;
        PreparedStatement byAll = getByAll(tsField,"");
        return byAll;
    }

    //查询条件
    protected PreparedStatement getByWhere(String wheres){
        String tsWheres="";
        if (wheres!=null&&!"".equals(wheres))
            tsWheres=wheres;
        PreparedStatement byAll = getByAll("",tsWheres);
        return byAll;
    }
    //插入
    private PreparedStatement Insert(){
        String tsSql ="insert into"+fromName+"values();";
        PreparedStatement statement = createStatement(tsSql);
        return statement;
    }

}

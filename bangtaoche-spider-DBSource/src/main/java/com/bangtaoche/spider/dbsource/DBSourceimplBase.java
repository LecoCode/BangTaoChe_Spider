package com.bangtaoche.spider.dbsource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceimplBase {
    Connection conn;
    protected DBSourceimplBase(Connection conn){
        this.conn=conn;
    }
    /**
     * 插入
     * @param from 表名
     * @param fieldValues 需要插入的字段值
     * @return 状态
     */
    protected int Insert(String from,String... fieldValues){
        StringBuilder sql = new StringBuilder("INSERT INTO "+from+" VALUES (");
        for (String s:
                fieldValues) {
            sql.append("\'"+s+"\',");
        }
        sql.append(");");
        try {
            int status = executeUpdate(sql.toString());
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 删除
     * @param from 表名
     * @param whereField 限制字段
     * @param WhereValue 限制值
     * @return 状态
     */
    protected int Delete(String from,String whereField,String WhereValue){
        String sql="DELETE FROM "+from+" WHERE "+whereField+" = "+WhereValue+";";
        try {
            int status = executeUpdate(sql);
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 更新
     * @param from 表名
     * @param field 更新的字段
     * @param value 更新的值
     * @param whereField 限制的字段
     * @param whereValue 限制的值
     * @return 状态
     */
    protected int Update(String from,String field,String value,String whereField,String whereValue){
        String sql="UPDATE "+from+" SET "+field+" = "+value+" WHERE "+whereField+" = "+whereValue+";";
        try {
            int status = executeUpdate(sql);
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询
     * @param from 表名
     * @param filed 查询的字段
     * @return
     * @throws SQLException
     */
    protected ResultSet Select(String from, String filed) throws SQLException {
        String sql ="SELECT "+filed +" FROM "+from;
        System.out.println(sql);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    //更新操作
    private int executeUpdate(String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int status = preparedStatement.executeUpdate();
        conn.close();
        return  status;
    }
}

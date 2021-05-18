package com.xyw.dao.impl;

import com.xyw.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();
    /*
    update() 执行语句
     */
    public int update(String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try{
            return queryRunner.update(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }


    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection con = JdbcUtils.getConnection();
        try{
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection con = JdbcUtils.getConnection();
        try{
            return (List<T>) queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object... args){
        Connection con = JdbcUtils.getConnection();
        try{
            return queryRunner.query(con,sql,new org.apache.commons.dbutils.handlers.ScalarHandler<>(),args);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

}

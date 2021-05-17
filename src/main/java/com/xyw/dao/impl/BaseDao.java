package com.xyw.dao.impl;

import com.xyw.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

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
        }
        return -1;
    }
}

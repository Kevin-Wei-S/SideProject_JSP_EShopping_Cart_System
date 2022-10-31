package com.backymeter.dao;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.backymeter.utils.JdbcUtils;

public abstract class BaseDao {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	
	// 增 刪 改 CUD
	public int update(String sql, Object...args) {
		
		Connection connection = JdbcUtils.getConnection();
		
		try {
			return queryRunner.update(connection, sql, args);
		} catch(Exception e) {
			e.printStackTrace();
			// 回滾事務, 須要拿到例外, 前面可以catch異常, 
			// 但得往外拋, 不然後面回滾無法偵測異常.
			throw new RuntimeException(e);
		} 
		
	}
	/* 
	   查詢返回 <一個> JavaBean語句 R
	   type 返回的類型
	   sql 	執行sql的語句
	   args	sql對應的參數
	   <T>	返回類型的泛型
	*/
	public <T>T queryForOne(Class<T> type, String sql, Object...args){
		
		Connection connection = JdbcUtils.getConnection();
		
		try {
			return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}
	
	/* 
	   查詢返回 <多個> JavaBean語句 R
	   type 返回的類型
	   sql 	執行sql的語句
	   args	sql對應的參數
	   <T>	返回類型的泛型
	*/
	
	public <T>List<T> queryForList(Class<T> type, String sql, Object...args) {
		
		Connection connection = JdbcUtils.getConnection();
		
		try {
			return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}
	
	/* 
	   查詢返回 座標尋值<單值> R
	   sql 	執行sql的語句
	   args	sql對應的參數
	*/
	public Object queryForSingleValue(String sql, Object...args) {
		
		Connection connection = JdbcUtils.getConnection();
		
		try {
			return queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}
	
}

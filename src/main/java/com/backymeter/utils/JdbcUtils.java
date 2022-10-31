package com.backymeter.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcUtils {
	
	private static DruidDataSource dataSource;
	private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
	
	static {
			
		try {
			Properties properties = new Properties();
			// 讀取 jdbc.properties
			InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// 從流中加載數據
			properties.load(inputStream);
			
			// 創建 數據庫連接池
			dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
			
		} catch(Exception e) {
			
			e.fillInStackTrace();
			
		}
		
		
	}
	 
	// 獲取數據庫連接池的連接
	// 如果返回null 獲取連接失敗 反之 有值獲取連接成功
	public static Connection getConnection() {
		
		Connection conn = conns.get();
		
		if(conn==null) {
			
			try {
				
				conn = dataSource.getConnection(); // 從數據庫連接池中獲取連接
				conns.set(conn);  // 保存到ThreadLocal中, 以供後面jdbc使用
				conn.setAutoCommit(false); // 設置為手動管理事務
			
			} catch(Exception e) {
				
				e.printStackTrace();	
			} 
		}

		return conn;
		
	}
	
	// 提交事務及關閉釋放連接
	public static void commitAndClose() {
		
		Connection conn = conns.get();
		
		if(conn != null) {
			
			try {
			
				conn.commit();
			
			} catch(Exception e){
			
				e.printStackTrace();
		
			} finally {	
			
				try {
					conn.close();
			
				} catch(Exception e) {
				
					e.printStackTrace();
		
				}			
			}
		}
		// 為不影響Tomcat底部線程運作, 使用後須刪除.
		conns.remove();
	}
	
	// 回滾及關閉連接	
	public static void rollbackAndClose() {
		
		Connection conn = conns.get();
		
		if(conn!=null) {
			
			try {
				
				conn.rollback();
			
			} catch(Exception e) {
			
				e.printStackTrace();
			
			} finally {
				
				try {
					
					conn.close();
				
				} catch(Exception e) {
				
					e.printStackTrace();
				
				}	
			}
		}
		// 為不影響Tomcat底部線程池運作, 應用完後須刪除.
		conns.remove();
	}
	
	/*
	// 關閉連接 放回數據庫連接池
	public static void close(Connection connection) {
		
		if(connection != null) {
			
			try {
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	*/
	
}

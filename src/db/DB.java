package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	//A connection with the db in jdbc is creating a connection class
	public static Connection getConnection() {
		if (conn == null) {
			try {
				//got the dburl with properties to use DiverManager to connect to the db 
				Properties props = LoadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		
		}
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties LoadProperties() {
		//load the properties thru the file 
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
		
	public static void closeStatment(Statement st) {
		if(st != null) {
			try {
				st.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void closeResultSet(ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
}


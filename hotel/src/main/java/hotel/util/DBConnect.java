package hotel.util;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnect {
	
 	private static Connection conn = null;
	
	public DBConnect() throws Exception {
		conn = getConnection();
	}
	
	private Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/Hotel?"
				+ "user=root&password=1234&useUnicode=true&characterEncoding=UTF8";
		Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
		return DriverManager.getConnection(url);
	}
	
	public Map<String, Object> queryForMap(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		int n = md.getColumnCount();
		rs.next();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 1; i <= n; i++) {
			
			map.put(md.getColumnName(i), rs.getObject(i));
		}
		stmt.close();
		return map;
	}
	
	public Map<String, Object> queryForMap(String sql, Object[] objs) throws SQLException {
		PreparedStatement  stmt = conn.prepareStatement(sql);
		for (int i = 0; i < objs.length; i++) {
			stmt.setObject(i + 1, objs[i]);
		}
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		int n = md.getColumnCount();
		rs.next();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 1; i <= n; i++) {
			
			map.put(md.getColumnName(i), rs.getObject(i));
		}
		stmt.close();
		return map;
	}
	public List<Map<String, Object>> queryForMapList(String sql) throws SQLException {
		List<Map<String, Object>> mapList = new ArrayList<>(); 
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		int n = md.getColumnCount();
		while(rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= n; i++) {
				map.put(md.getColumnName(i), rs.getObject(i));
			}
			mapList.add(map);
		}
		
		stmt.close();
		return mapList;
	}
	public boolean sqlForBool(String sql) {
		try {
			Statement stmt = conn.createStatement();
			boolean a=stmt.execute(sql);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean sqlForBool(String sql,Object[] objs){
		try{
			PreparedStatement  stmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				stmt.setObject(i + 1, objs[i]);
			}
			
			stmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}

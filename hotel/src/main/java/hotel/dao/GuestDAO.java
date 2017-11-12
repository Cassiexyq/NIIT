package hotel.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import hotel.model.Guest;
import hotel.util.DBConnect;

public class GuestDAO {
	
	private DBConnect db;
	
	public GuestDAO() throws Exception {
		db = new DBConnect();
	}
	
	public List<Map<String, Object>> getAllGuest() throws SQLException {
		String sql = "SELECT * FROM guest";
		return db.queryForMapList(sql);
	}
	
	public boolean addGuest(Guest guest) throws SQLException {
		String sql = "INSERT INTO guest VALUES (?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{guest.getGno(),guest.getGname(),guest.getGsex(),guest.getGtel(),guest.getGid(),guest.getGaddress()};
		return db.sqlForBool(sql, params);
	}
	
	public boolean deleteGuest(Guest guest) throws SQLException{
		String sql="delete from guest where Gno=?";
		Object[] params=new Object[]{guest.getGno()};
		return db.sqlForBool(sql, params);
	}
	
	public boolean updataGuest(Guest guest) throws SQLException{
		String sql="update guest set Gtel=? where Gno=?";
		Object[] params=new Object[]{guest.getGtel(),guest.getGno()};
		return db.sqlForBool(sql, params);
	}
	
}

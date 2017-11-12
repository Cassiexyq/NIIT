package hotel.dao;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import hotel.model.Guest;
import hotel.model.Room;
import hotel.model.Waiter;
import hotel.util.DBConnect;
public class RoomDAO {
private DBConnect db;
	
	public RoomDAO() throws Exception {
		db = new DBConnect();
	}
	
	public List<Map<String, Object>> getAllRoom() throws SQLException {
		String sql = "SELECT * FROM roominfo";
		return db.queryForMapList(sql);
	}
	public List<Map<String, Object>> getEmptyRoom_singal() throws SQLException {
		String sql = "SELECT roominfo.Rno,Rstate,Rtype,Rprice,Rfloor,Rdri FROM roomstate,roominfo WHERE Rstate='空' and Rtype='单人间' and roominfo.Rno=roomstate.Rno";	
			return db.queryForMapList(sql);
	}
	public List<Map<String, Object>> getEmptyRoom_standard() throws SQLException {
		String sql = "SELECT roominfo.Rno,Rstate,Rtype,Rprice,Rfloor,Rdri FROM roomstate,roominfo WHERE Rstate='空'and Rtype='标准间' and roominfo.Rno=roomstate.Rno";	
			return db.queryForMapList(sql);
	}
	public List<Map<String, Object>> getEmptyRoom_triple() throws SQLException {
		String sql = "SELECT roominfo.Rno,Rstate,Rtype,Rprice,Rfloor,Rdri FROM roomstate,roominfo WHERE Rstate='空'and Rtype='三人间' and roominfo.Rno=roomstate.Rno";	
			return db.queryForMapList(sql);
	}
	public List<Map<String, Object>> getNotEmptyRoom() throws SQLException {
		String sql = "SELECT * FROM roomstate WHERE Rstate='非空'";
		return db.queryForMapList(sql);
	}
	
	public boolean addRoom(Room hotel) throws SQLException {
		String sql = "INSERT INTO roominfo VALUES(?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{hotel.getRno(),hotel.getRtype(),hotel.getRprice(),hotel.getRfloor(),hotel.getRdri(),hotel.getRsno()};
		return db.sqlForBool(sql, params);
	}
	
	public boolean deleteRoom(Room hotel) throws SQLException{
		String sql="delete from roominfo where Rno=?";
		Object[] params=new Object[]{hotel.getRno()};
		return db.sqlForBool(sql, params);
	}
	public boolean updataRoom(Room room) throws SQLException{
		String sql="update roominfo set Rtype=?,Rprice=?,RSno=? where Rno=?";
		Object[] params=new Object[]{room.getRtype(),room.getRprice(),room.getRsno(),room.getRno()};
		return db.sqlForBool(sql, params);
	}
	public boolean reserveRoom(Room room) throws SQLException{
		String sql="update roomstate set Rstate='非空',Gno=?,Rin=?,Rout=? where Rno=?";
		Object[] params=new Object[]{room.getGno(),room.getRin(),room.getRout(),room.getRno()};
		return db.sqlForBool(sql, params);
	}
	public boolean checkoutRoom(Room room) throws SQLException{
		String sql="update roomstate set Rstate='空',Gno=null,Rin=null,Rout=null where Rno=?";
		Object[] params=new Object[]{room.getRno()};
		return db.sqlForBool(sql, params);
	}
	
	
}

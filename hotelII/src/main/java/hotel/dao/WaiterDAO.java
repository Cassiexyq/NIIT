package hotel.dao;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import hotel.model.Waiter;
import hotel.util.DBConnect;
public class WaiterDAO {
	private DBConnect db;
	
	public WaiterDAO() throws Exception {
		db = new DBConnect();
	}
	
	public List<Map<String, Object>> getAllWaiter() throws SQLException {
		String sql = "SELECT * FROM waiter";
		return db.queryForMapList(sql);
	}
	
	public boolean addWaiter(Waiter waiter) throws SQLException {
		String sql = "INSERT INTO waiter VALUES (?, ?, ?, ?)";
		Object[] params = new Object[]{waiter.getWno(),waiter.getWname(),waiter.getWsex(),waiter.getWtel()};
		return db.sqlForBool(sql, params);
	}
	
	public boolean deleteWaiter(Waiter waiter) throws SQLException{
		String sql="delete from waiter where Wno=?";
		Object[] params=new Object[]{waiter.getWno()};
		return db.sqlForBool(sql, params);
	}
	public boolean updataWaiter(Waiter waiter) throws SQLException{
		String sql="update waiter set Wtel=? where Wno=?";
		Object[] params=new Object[]{waiter.getWtel(),waiter.getWno()};
		return db.sqlForBool(sql, params);
	}
	
}

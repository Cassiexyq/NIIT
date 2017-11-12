package hotel.model;

import java.util.Map;

public class Guest {
	
	public Guest() {}
	
	public Guest(Map<String, Object> map) {
		Guest guest = new Guest();
		guest.setGid((String)map.get("gid")); 
	}
	private String Gno;
	private String Gname;
	private String Gsex;
	private String Gtel;
	private String Gid;
	private String Gaddress;
	public String getGno() {
		return Gno;
	}
	public void setGno(String gno) {
		Gno = gno;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public String getGsex() {
		return Gsex;
	}
	public void setGsex(String gsex) {
		Gsex = gsex;
	}
	public String getGtel() {
		return Gtel;
	}
	public void setGtel(String gtel) {
		Gtel = gtel;
	}
	public String getGid() {
		return Gid;
	}
	public void setGid(String gid) {
		Gid = gid;
	}
	public String getGaddress() {
		return Gaddress;
	}
	public void setGaddress(String gadress) {
		Gaddress = gadress;
	}
}

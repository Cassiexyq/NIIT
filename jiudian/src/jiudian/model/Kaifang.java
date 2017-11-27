package jiudian.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Kaifang")
public class Kaifang {

	@Id
	@GeneratedValue
	private int id;//主键
	
	
	
	@ManyToOne
	@JoinColumn(name="kefangid")
	private Kefang kefang;//关联分类的id外键
	
	private String kehuname;//客户姓名
	
	private String idcard;//身份证号
	
	private double yajin;//押金
	
	private String beizhu;//备注
	
	private Date ruzhutime;//入住时间
	
	private Date tuifangtime;//退房时间
	
   private String jiezhangstatus;//结账状态 分2种状态 已结账 未结账
   
   private double xiaofei;//消费金额
   
   private int tianshu;//入住的天数  

public double getXiaofei() {
	return xiaofei;
}

public void setXiaofei(double xiaofei) {
	this.xiaofei = xiaofei;
}

public int getTianshu() {
	return tianshu;
}

public void setTianshu(int tianshu) {
	this.tianshu = tianshu;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public Kefang getKefang() {
	return kefang;
}

public void setKefang(Kefang kefang) {
	this.kefang = kefang;
}

public String getKehuname() {
	return kehuname;
}

public void setKehuname(String kehuname) {
	this.kehuname = kehuname;
}

public String getIdcard() {
	return idcard;
}

public void setIdcard(String idcard) {
	this.idcard = idcard;
}

public double getYajin() {
	return yajin;
}

public void setYajin(double yajin) {
	this.yajin = yajin;
}



public String getBeizhu() {
	return beizhu;
}

public void setBeizhu(String beizhu) {
	this.beizhu = beizhu;
}

public Date getRuzhutime() {
	return ruzhutime;
}

public void setRuzhutime(Date ruzhutime) {
	this.ruzhutime = ruzhutime;
}

public Date getTuifangtime() {
	return tuifangtime;
}

public void setTuifangtime(Date tuifangtime) {
	this.tuifangtime = tuifangtime;
}

public String getJiezhangstatus() {
	return jiezhangstatus;
}

public void setJiezhangstatus(String jiezhangstatus) {
	this.jiezhangstatus = jiezhangstatus;
}
	
   
	
	


	
	
}

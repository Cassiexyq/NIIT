package jiudian.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Yuding")
public class Yuding {

	@Id
	@GeneratedValue
	private int id;//主键
	

	private String truename;//真实姓名
	
	private String xingbie;//男 女  

	private String yudingtime;//预定入住时间
	
	private Date createtime;//添加时间    

	private String lianxifangshi;//联系方式
	
	private String yudingidcard;//预定客户的身份证号码  
	
	private int yudingstatus;//用户状态 0表示预定状态 1表示取消预定
	
	private String beizhu;//备注
	
	@ManyToOne
	@JoinColumn(name="kefangid")
	private Kefang kefang;//关联kefang的id 外键
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//关联kefang的id 外键
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Kefang getKefang() {
		return kefang;
	}

	public void setKefang(Kefang kefang) {
		this.kefang = kefang;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	

	public String getYudingtime() {
		return yudingtime;
	}

	public void setYudingtime(String yudingtime) {
		this.yudingtime = yudingtime;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getLianxifangshi() {
		return lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}

	public int getYudingstatus() {
		return yudingstatus;
	}

	public void setYudingstatus(int yudingstatus) {
		this.yudingstatus = yudingstatus;
	}

	public String getYudingidcard() {
		return yudingidcard;
	}

	public void setYudingidcard(String yudingidcard) {
		this.yudingidcard = yudingidcard;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	
}

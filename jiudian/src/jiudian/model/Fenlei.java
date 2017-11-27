package jiudian.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//房间分类表
@Entity
@Table(name="t_Fenlei")
public class Fenlei {

	@Id
	@GeneratedValue
	private int id;//主键
	
	private String leixing;//房间类型
	
	private double jiage;//房间价格
	
	private int deletestatus;//房间类型对应的状态 0表示正常状态 1表示删除状态
	
	private Date createtime;//添加时间
	
	
	

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public double getJiage() {
		return jiage;
	}

	public void setJiage(double jiage) {
		this.jiage = jiage;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	
	
	

	
}

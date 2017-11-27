package jiudian.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Kefang")
public class Kefang {

	@Id
	@GeneratedValue
	private int id;//主键
	
	
	@ManyToOne
	@JoinColumn(name="fenleiid")
	private Fenlei fenlei;//关联分类的id外键
	
	private String fangjianhao;//房间编号
	
	private String miaoshu;//房间描述
	
	private String fangjianstatus;//房间状态分 空房 、开房、预定 3种状态
	
	
	private int deletestatus;// 房间信息状态 0表示未删除 1表示删除

	
	
	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fenlei getFenlei() {
		return fenlei;
	}

	public void setFenlei(Fenlei fenlei) {
		this.fenlei = fenlei;
	}

	public String getFangjianhao() {
		return fangjianhao;
	}

	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}

	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	

	public String getFangjianstatus() {
		return fangjianstatus;
	}

	public void setFangjianstatus(String fangjianstatus) {
		this.fangjianstatus = fangjianstatus;
	}

	
	
	
	
}

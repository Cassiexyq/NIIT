package jiudian.dao;

import java.util.List;

import jiudian.model.Fenlei;





public interface FenleiDao  {
	
	
	
	public void insertBean(Fenlei bean);
	
	public void deleteBean(Fenlei bean);
	
	public void updateBean(Fenlei bean);

	public Fenlei selectBean(String where);
	
	public List<Fenlei> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}

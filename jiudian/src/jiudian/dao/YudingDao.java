package jiudian.dao;

import java.util.List;

import jiudian.model.Yuding;





public interface YudingDao  {
	
	
	
	public void insertBean(Yuding bean);
	
	public void deleteBean(Yuding bean);
	
	public void updateBean(Yuding bean);

	public Yuding selectBean(String where);
	
	public List<Yuding> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}

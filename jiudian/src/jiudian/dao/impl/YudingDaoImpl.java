package jiudian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import jiudian.dao.YudingDao;
import jiudian.model.Yuding;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;











public class YudingDaoImpl extends HibernateDaoSupport implements  YudingDao{


	public void deleteBean(Yuding bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Yuding bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Yuding selectBean(String where) {
		List<Yuding> list = this.getHibernateTemplate().find("from Yuding " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Yuding "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Yuding> selectBeanList(final int start,final int limit,final String where) {
		return (List<Yuding>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Yuding> list = session.createQuery("from Yuding "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Yuding bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}

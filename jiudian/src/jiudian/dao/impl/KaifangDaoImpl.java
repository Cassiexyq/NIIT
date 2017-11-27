package jiudian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import jiudian.dao.KaifangDao;
import jiudian.model.Kaifang;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;











public class KaifangDaoImpl extends HibernateDaoSupport implements  KaifangDao{


	public void deleteBean(Kaifang bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Kaifang bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Kaifang selectBean(String where) {
		List<Kaifang> list = this.getHibernateTemplate().find("from Kaifang " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kaifang "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kaifang> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kaifang>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kaifang> list = session.createQuery("from Kaifang "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kaifang bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}

package jiudian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import jiudian.dao.KefangDao;
import jiudian.model.Kefang;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class KefangDaoImpl extends HibernateDaoSupport implements  KefangDao{


	public void deleteBean(Kefang bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Kefang bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Kefang selectBean(String where) {
		List<Kefang> list = this.getHibernateTemplate().find("from Kefang " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kefang "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kefang> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kefang>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kefang> list = session.createQuery("from Kefang "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kefang bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}

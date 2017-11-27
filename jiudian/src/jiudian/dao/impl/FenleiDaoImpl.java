package jiudian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import jiudian.dao.FenleiDao;
import jiudian.model.Fenlei;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FenleiDaoImpl extends HibernateDaoSupport implements  FenleiDao{


	public void deleteBean(Fenlei bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Fenlei bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Fenlei selectBean(String where) {
		List<Fenlei> list = this.getHibernateTemplate().find("from Fenlei " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Fenlei "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Fenlei> selectBeanList(final int start,final int limit,final String where) {
		return (List<Fenlei>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Fenlei> list = session.createQuery("from Fenlei "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Fenlei bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}

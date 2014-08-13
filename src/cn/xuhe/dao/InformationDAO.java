package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Information;

/**
 * A data access object (DAO) providing persistence and search support for
 * Information entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.xuhe.entity.Information
 * @author MyEclipse Persistence Tools
 */

public class InformationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InformationDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String PIC = "pic";
	public static final String TYPE = "type";
	public static final String DATE = "date";
	public static final String TOP = "top";

	protected void initDao() {
		// do nothing
	}

	public void save(Information transientInstance) {
		log.debug("saving Information instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Information transientInstance) {
		System.out.println("updating Information instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Information persistentInstance) {
		log.debug("deleting Information instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Information findById(java.lang.Integer id) {
		log.debug("getting Information instance with id: " + id);
		try {
			Information instance = (Information) getHibernateTemplate().get(
					"cn.xuhe.entity.Information", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Information instance) {
		log.debug("finding Information instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Information instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Information as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByTop(Object top) {
		return findByProperty(TOP, top);
	}

	public List findAll() {
		log.debug("finding all Information instances");
		try {
			String queryString = "from Information";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Information merge(Information detachedInstance) {
		log.debug("merging Information instance");
		try {
			Information result = (Information) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Information instance) {
		log.debug("attaching dirty Information instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Information instance) {
		log.debug("attaching clean Information instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InformationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InformationDAO) ctx.getBean("InformationDAO");
	}
}
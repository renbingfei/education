package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Ephoto;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ephoto entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.xuhe.entity.Ephoto
 * @author MyEclipse Persistence Tools
 */

public class EphotoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EphotoDAO.class);
	// property constants
	public static final String ENTERPRISEID = "enterpriseid";
	public static final String DATE = "date";
	public static final String URL = "url";

	protected void initDao() {
		// do nothing
	}

	public void save(Ephoto transientInstance) {
		log.debug("saving Ephoto instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ephoto persistentInstance) {
		log.debug("deleting Ephoto instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ephoto findById(java.lang.Integer id) {
		log.debug("getting Ephoto instance with id: " + id);
		try {
			Ephoto instance = (Ephoto) getHibernateTemplate().get(
					"cn.xuhe.entity.Ephoto", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ephoto instance) {
		log.debug("finding Ephoto instance by example");
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
		log.debug("finding Ephoto instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ephoto as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEnterpriseid(Object enterpriseid) {
		return findByProperty(ENTERPRISEID, enterpriseid);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findAll() {
		log.debug("finding all Ephoto instances");
		try {
			String queryString = "from Ephoto";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ephoto merge(Ephoto detachedInstance) {
		log.debug("merging Ephoto instance");
		try {
			Ephoto result = (Ephoto) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ephoto instance) {
		log.debug("attaching dirty Ephoto instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ephoto instance) {
		log.debug("attaching clean Ephoto instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EphotoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EphotoDAO) ctx.getBean("EphotoDAO");
	}
}
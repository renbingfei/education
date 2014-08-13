package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Infotemp;

/**
 * A data access object (DAO) providing persistence and search support for
 * Infotemp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.xuhe.entity.Infotemp
 * @author MyEclipse Persistence Tools
 */

public class InfotempDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InfotempDAO.class);
	// property constants
	public static final String DETAIL = "detail";
	public static final String INFOTAG = "infotag";

	protected void initDao() {
		// do nothing
	}

	public void save(Infotemp transientInstance) {
		log.debug("saving Infotemp instance");
//		System.out.println("saving Infotemp instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
//			System.out.println("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
//			System.out.println("save failed"+ re);
			throw re;
		}
	}

	public void delete(Infotemp persistentInstance) {
		log.debug("deleting Infotemp instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Infotemp findById(java.lang.Integer id) {
		log.debug("getting Infotemp instance with id: " + id);
		try {
			Infotemp instance = (Infotemp) getHibernateTemplate().get(
					"cn.xuhe.entity.Infotemp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Infotemp instance) {
		log.debug("finding Infotemp instance by example");
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
		log.debug("finding Infotemp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Infotemp as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDetail(Object detail) {
		return findByProperty(DETAIL, detail);
	}

	public List findByInfotag(Object infotag) {
		return findByProperty(INFOTAG, infotag);
	}

	public List findAll() {
		log.debug("finding all Infotemp instances");
		try {
			String queryString = "from Infotemp";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Infotemp merge(Infotemp detachedInstance) {
		log.debug("merging Infotemp instance");
		try {
			Infotemp result = (Infotemp) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Infotemp instance) {
		log.debug("attaching dirty Infotemp instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Infotemp instance) {
		log.debug("attaching clean Infotemp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InfotempDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InfotempDAO) ctx.getBean("InfotempDAO");
	}
}
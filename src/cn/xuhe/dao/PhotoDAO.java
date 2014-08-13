package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Photo;

/**
 * A data access object (DAO) providing persistence and search support for Photo
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.xuhe.entity.Photo
 * @author MyEclipse Persistence Tools
 */

public class PhotoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PhotoDAO.class);
	// property constants
	public static final String STUDENTID = "studentid";
	public static final String URL = "url";
	public static final String DATE = "date";
	public static final String STATEMENT = "statement";
	public static final String ISVIDEO = "isvideo";

	protected void initDao() {
		// do nothing
	}

	public void save(Photo transientInstance) {
		log.debug("saving Photo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Photo persistentInstance) {
		log.debug("deleting Photo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Photo findById(java.lang.Integer id) {
		log.debug("getting Photo instance with id: " + id);
		try {
			Photo instance = (Photo) getHibernateTemplate().get(
					"cn.xuhe.entity.Photo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Photo instance) {
		log.debug("finding Photo instance by example");
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
		log.debug("finding Photo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Photo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentid(Object studentid) {
		return findByProperty(STUDENTID, studentid);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByStatement(Object statement) {
		return findByProperty(STATEMENT, statement);
	}

	public List findByIsvideo(Object isvideo) {
		return findByProperty(ISVIDEO, isvideo);
	}

	public List findAll() {
		log.debug("finding all Photo instances");
		try {
			String queryString = "from Photo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Photo merge(Photo detachedInstance) {
		log.debug("merging Photo instance");
		try {
			Photo result = (Photo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Photo instance) {
		log.debug("attaching dirty Photo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Photo instance) {
		log.debug("attaching clean Photo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PhotoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PhotoDAO) ctx.getBean("PhotoDAO");
	}
}
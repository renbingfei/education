package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Blog;

/**
 * A data access object (DAO) providing persistence and search support for Blog
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.xuhe.entity.Blog
 * @author MyEclipse Persistence Tools
 */

public class BlogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BlogDAO.class);
	// property constants
	public static final String DATE = "date";
	public static final String STUDENTID = "studentid";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String URL = "url";
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Blog transientInstance) {
		log.debug("saving Blog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Blog persistentInstance) {
		log.debug("deleting Blog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Blog findById(java.lang.Integer id) {
		log.debug("getting Blog instance with id: " + id);
		try {
			Blog instance = (Blog) getHibernateTemplate().get(
					"cn.xuhe.entity.Blog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Blog instance) {
		log.debug("finding Blog instance by example");
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
		log.debug("finding Blog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByStudentid(Object studentid) {
		return findByProperty(STUDENTID, studentid);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Blog instances");
		try {
			String queryString = "from Blog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blog merge(Blog detachedInstance) {
		log.debug("merging Blog instance");
		try {
			Blog result = (Blog) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blog instance) {
		log.debug("attaching dirty Blog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Blog instance) {
		log.debug("attaching clean Blog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogDAO) ctx.getBean("BlogDAO");
	}
}
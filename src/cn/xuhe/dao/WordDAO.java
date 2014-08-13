package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Word;

/**
 * A data access object (DAO) providing persistence and search support for Word
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.xuhe.entity.Word
 * @author MyEclipse Persistence Tools
 */

public class WordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(WordDAO.class);
	// property constants
	public static final String DATE = "date";
	public static final String STUDENTID = "studentid";
	public static final String BLOGID = "blogid";
	public static final String CONTENT = "content";
	public static final String NAME = "name";
	public static final String AVATAR = "avatar";

	protected void initDao() {
		// do nothing
	}

	public void save(Word transientInstance) {
		log.debug("saving Word instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Word persistentInstance) {
		log.debug("deleting Word instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Word findById(java.lang.Integer id) {
		log.debug("getting Word instance with id: " + id);
		try {
			Word instance = (Word) getHibernateTemplate().get(
					"cn.xuhe.entity.Word", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Word instance) {
		log.debug("finding Word instance by example");
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
		log.debug("finding Word instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Word as model where model."
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

	public List findByBlogid(Object blogid) {
		return findByProperty(BLOGID, blogid);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	public List findAll() {
		log.debug("finding all Word instances");
		try {
			String queryString = "from Word";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Word merge(Word detachedInstance) {
		log.debug("merging Word instance");
		try {
			Word result = (Word) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Word instance) {
		log.debug("attaching dirty Word instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Word instance) {
		log.debug("attaching clean Word instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WordDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WordDAO) ctx.getBean("WordDAO");
	}
}
package cn.xuhe.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.xuhe.entity.Ppqa;

/**
 * A data access object (DAO) providing persistence and search support for Ppqa
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.xuhe.entity.Ppqa
 * @author MyEclipse Persistence Tools
 */

public class PpqaDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PpqaDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String QUESTION1 = "question1";
	public static final String ANSWER1 = "answer1";
	public static final String QUESTION2 = "question2";
	public static final String ANSWER2 = "answer2";
	public static final String QUESTION3 = "question3";
	public static final String ANSWER3 = "answer3";

	protected void initDao() {
		// do nothing
	}

	public void save(Ppqa transientInstance) {
		log.debug("saving Ppqa instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ppqa persistentInstance) {
		log.debug("deleting Ppqa instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ppqa findById(java.lang.Integer id) {
		log.debug("getting Ppqa instance with id: " + id);
		try {
			Ppqa instance = (Ppqa) getHibernateTemplate().get(
					"cn.xuhe.entity.Ppqa", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ppqa instance) {
		log.debug("finding Ppqa instance by example");
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
		log.debug("finding Ppqa instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ppqa as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByQuestion1(Object question1) {
		return findByProperty(QUESTION1, question1);
	}

	public List findByAnswer1(Object answer1) {
		return findByProperty(ANSWER1, answer1);
	}

	public List findByQuestion2(Object question2) {
		return findByProperty(QUESTION2, question2);
	}

	public List findByAnswer2(Object answer2) {
		return findByProperty(ANSWER2, answer2);
	}

	public List findByQuestion3(Object question3) {
		return findByProperty(QUESTION3, question3);
	}

	public List findByAnswer3(Object answer3) {
		return findByProperty(ANSWER3, answer3);
	}

	public List findAll() {
		log.debug("finding all Ppqa instances");
		try {
			String queryString = "from Ppqa";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ppqa merge(Ppqa detachedInstance) {
		log.debug("merging Ppqa instance");
		try {
			Ppqa result = (Ppqa) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ppqa instance) {
		log.debug("attaching dirty Ppqa instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ppqa instance) {
		log.debug("attaching clean Ppqa instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PpqaDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PpqaDAO) ctx.getBean("PpqaDAO");
	}
}
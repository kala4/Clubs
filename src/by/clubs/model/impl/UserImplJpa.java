package by.clubs.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import by.gsu.epamlab.controllers.Constants;
import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.utils.HibernateJpaUtil;
import by.gsu.epamlab.utils.TheatreExeption;


/**
 * @author Kalachev
 *
 */
public class UserImplJpa implements IUserDAO {
	
	private static final Logger LOG = Logger.getLogger(UserImplJpa.class);

	@Override
	public void createUser(User u) throws TheatreExeption {
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				User user = new User();
				user.setLogin(u.getLogin());
				user.setPassword(u.getPassword());
				user.setPhone(u.getPhone());
				user.setRole(u.getRole());
				user.setDeleted(false);
				em.persist(user);
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
		} catch (Exception e) {
			LOG.error("Exeption in method createUser(User u): "+e.getMessage(), e);
			throw new TheatreExeption();
		}
	}

	@Override
	public int getId(String name) throws TheatreExeption {
		int result = 0;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_USER_ID);
				query.setParameter(1, name);
				//TODO: Is it possible to do it without getResultList
				List<Integer> ids = query.getResultList();
				if (!ids.isEmpty()) {
					result = (Integer)ids.get(0);
				}
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
		} catch (Exception e) {
			LOG.error("Exeption in method getId(String name): "+e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public boolean isLoginFree(String login) throws TheatreExeption {
		boolean result = false;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.IS_LOGIN_FREE);
				query.setParameter(1, login);

				if (query.getResultList().isEmpty()) {
					result = true;
				}
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error("Exeption in method isLoginFree(String login): "+e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public User loginUser(String login, String password) throws TheatreExeption {
		User result = null;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.LOGIN_USER);
				query.setParameter(1, login);
				query.setParameter(2, password);
				List<User> users = query.getResultList();
				if (!users.isEmpty()) {
					result = (User)users.get(0);
				}

				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			

		} catch (Exception e) {
			LOG.error("Exeption in method loginUser(String login, String password): "+e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public User getUser(int id) throws TheatreExeption {
		User result = null;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			try{
				result = em.find(User.class, id);
			}finally{
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public long getAllUsersSize() throws TheatreExeption {
		long result = 0;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_ALL_USERS_COUNT);
				result = (Long)query.getSingleResult();
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public long getDefinedUsersSize(Role role) throws TheatreExeption {
		long result = 0;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_DEFINED_USERS_COUNT);
				query.setParameter(1, role);
				result = (Long)query.getSingleResult();
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}

	@Override
	public List<User> getDefinedUsers(Role currentRole, int page) throws TheatreExeption {
		List<User> users = new ArrayList<User>();
		
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_DEFINED_USERS);
				query.setParameter(1, currentRole);
				query.setFirstResult((page-1)*Constants.PAGE_SIZE);
				query.setMaxResults(Constants.PAGE_SIZE);
				users = query.getResultList();
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return users;
	}

	@Override
	public List<User> getAllUsers(int page) throws TheatreExeption {
		List<User> users = new ArrayList<User>();
		
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_ALL_USERS);
				query.setFirstResult((page-1)*Constants.PAGE_SIZE);
				query.setMaxResults(Constants.PAGE_SIZE);
				users = query.getResultList();
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return users;
	}

	@Override
	public void updateUser(User user) throws TheatreExeption {
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				User userx = em.find(User.class, user.getId());
				userx.setLogin(user.getLogin());
				userx.setPassword(user.getPassword());
				userx.setPhone(user.getPhone());
				userx.setRole(user.getRole());
				userx.setDeleted(user.isDeleted());
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
	}

	@Override
	public long getDeletedSize() throws TheatreExeption {
		long result = 0;
		try {
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_DELETED_USERS_COUNT);
				result = (Long)query.getSingleResult();
				t.commit();
			}finally{
				if (t.isActive()) {
					t.rollback();
				}
				em.close();
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return result;
	}
}

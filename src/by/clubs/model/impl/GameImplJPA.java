package by.clubs.model.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import by.clubs.actions.Constants;
import by.clubs.ifaces.IGameDAO;
import by.clubs.model.beans.Game;
import by.clubs.utils.HibernateJpaUtil;
import by.clubs.utils.TheatreExeption;

/**
 * JPA DAO implementation for Game
 * @author kalachou
 *
 */
public class GameImplJPA implements IGameDAO 
{

	/** Logger */
	private static final Logger LOG = Logger.getLogger(GameImplJPA.class);
	
	
	/**
	 * Creates new Game
	 * @param g - game to be saved
	 * @throws TheatreExeption
	 */
	@Override
	public void createGame(Game g) throws TheatreExeption 
	{
		try 
		{
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try
			{
				t.begin();
				Game game = new Game();
				game.setDateCreated(new Date());
				game.setDateUpdated(new Date());
				game.setDeleted(false);
				em.persist(game);
				t.commit();
			}
			finally
			{
				if (t.isActive()) 
				{
					t.rollback();
				}
				em.close();
			}
		} 
		catch (Exception e) 
		{
			LOG.error("Exeption in method createUser(User u): " + e.getMessage(), e);
			throw new TheatreExeption();
		}
	}

	/**
	 * Updates the game
	 * @param game - game to be saved
	 * @throws TheatreExeption
	 */
	@Override
	public void updateGame(Game game) throws TheatreExeption 
	{
		try 
		{
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try
			{
				t.begin();
				Game gameX = em.find(Game.class, game.getId());
				gameX.setDateCreated(game.getDateCreated());
				gameX.setDateUpdated(game.getDateUpdated());
				gameX.setDeleted(game.isDeleted());
				gameX.setPlayers(game.getPlayers());
				gameX.setResult(game.getResult());
				gameX.setSets(game.getSets());
				gameX.setWinner(game.getWinner());

				t.commit();
			}
			finally
			{
				if (t.isActive()) 
				{
					t.rollback();
				}
				em.close();
			}
		} 
		catch (Exception e) 
		{
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
	}

	/**
	 * Gets list of the games
	 * @param page - number of the page to be displayed
	 * @return List of games for current page
	 * @throws TheatreExeption
	 */
	@Override
	public List<Game> getGamesList(int page) throws TheatreExeption 
	{
		List<Game> games = new ArrayList<Game>();
		
		try 
		{
			EntityManager em = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			try
			{
				t.begin();
				Query query = em.createQuery(ConstantsJpa.GET_GAMES_LIST);
				query.setFirstResult((page - 1) * Constants.PAGE_SIZE);
				query.setMaxResults(Constants.PAGE_SIZE);
				games = query.getResultList();
				t.commit();
			}
			finally
			{
				if (t.isActive()) 
				{
					t.rollback();
				}
				em.close();
			}
			
		} 
		catch (Exception e) 
		{
			LOG.error(e.getMessage(), e);
			throw new TheatreExeption();
		}
		return games;
	}

}

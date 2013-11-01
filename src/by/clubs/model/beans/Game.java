package by.clubs.model.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistence entity class which maps to the Games table in database
 * @author Aliaksei_Kalachou
 *
 */
@Entity
@Table(name = "GAMES")
public class Game 
{
	/** ID */
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private int m_id;
	
	/** Date of creation */
	@Column(name = "DATE_CREATED")
	private Date m_dateCreated;
	
	/** date of last modification */
	@Column(name = "DATE_UPDATED")
	private Date m_dateUpdated;
	
	/** Deleted flag */
	@Column(name = "IS_DELETED")
	private boolean m_isDeleted;
	/** List of players */
	private List<User> m_players;
	
	/** List of game sets */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "GAMES")
	private List<Set> m_sets;
	
	/** Winner */
	@OneToOne
	@JoinColumn(name = "WINNER_ID", nullable = true, insertable = true, updatable = true, unique = false)
	private User m_winner;
	
	/** Winners result in the game */
	@Column(name = "RESULT")
	private int m_result;
	
	/**
	 * Getter for game id
	 * @return id
	 */
	public int getId() 
	{
		return m_id;
	}
	
	/**
	 * Setter for game id
	 * @param id - id to be set
	 */
	public void setId(int id) 
	{
		this.m_id = id;
	}
	
	/**
	 * Getter for current game users
	 * @return List of users
	 */
	public List<User> getPlayers() 
	{
		return m_players;
	}
	
	/**
	 * Setter for current game players
	 * @param players - list of users to be set
	 */
	public void setPlayers(List<User> players) 
	{
		this.m_players = players;
	}
	
	/**
	 * Getter for the game sets
	 * @return List of game sets
	 */
	public List<Set> getSets() 
	{
		return m_sets;
	}
	
	/** 
	 * Setter for the current game sets
	 * @param sets - list of game sets
	 */
	public void setSets(List<Set> sets) 
	{
		this.m_sets = sets;
	}
	
	/**
	 * Getter for the game winner
	 * @return User who win the game
	 */
	public User getWinner() 
	{
		return m_winner;
	}
	
	/**
	 * Setter for game winner
	 * @param winner - user who win the game
	 */
	public void setWinner(User winner) 
	{
		this.m_winner = winner;
	}
	
	/**
	 * Getter for the game result
	 * @return result
	 */
	public int getResult() 
	{
		return m_result;
	}
	
	/**
	 * Setter for the game result
	 * @param result - result to be set
	 */
	public void setResult(int result) 
	{
		this.m_result = result;
	}
	
	/**
	 * Getter for the date of game creation
	 * @return game creation date
	 */
	public Date getDateCreated() 
	{
		return m_dateCreated;
	}
	
	/**
	 * Setter for the game creation date
	 * @param dateCreated - date of game creation
	 */
	public void setDateCreated(Date dateCreated) 
	{
		this.m_dateCreated = dateCreated;
	}
	
	/**
	 * Getter for the last date of game modification
	 * @return game modification date
	 */
	public Date getDateUpdated() 
	{
		return m_dateUpdated;
	}
	
	/**
	 * Setter for the last date of game modification
	 * @param dateUpdated - date of game modification
	 */
	public void setDateUpdated(Date dateUpdated) 
	{
		this.m_dateUpdated = dateUpdated;
	}
	
	/**
	 * Getter for the isDeleted flag
	 * @return isDeleted flag
	 */
	public boolean isDeleted() 
	{
		return m_isDeleted;
	}
	
	/**
	 * Setter for the isDeleted flag
	 * @param isDeleted - flag to be set
	 */
	public void setDeleted(boolean isDeleted) 
	{
		this.m_isDeleted = isDeleted;
	}
}

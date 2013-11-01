package by.clubs.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistence entity class which maps to the Sets table in database
 * @author Aliaksei_Kalachou
 *
 */
@Entity
@Table(name = "SETS")
public class Set 
{
	/** ID */
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private int id;
	
	/** Game */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID")
	private Game game;
	
	/** Creation date */
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	/** madification date */
	@Column(name = "DATE_UPDATED")
	private Date dateUpdated;
	
	/** Deletion flag */
	@Column(name = "IS_DELETED")
	private boolean isDeleted;
	
	/** Winner of the set */
	@OneToOne
	@JoinColumn(name = "WINNER_ID", nullable=true, insertable=true, updatable=true, unique=false)
	private User winner;
	
	/** Set's result */
	@Column(name = "RESULT")
	private int result;
	
	
	/**
	 * Getter for the set's id
	 * @return id
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Setter for the Set's id
	 * @param id - id to be set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
	
	/**
	 * Getter for the date of Set creation
	 * @return Set's creation date
	 */
	public Date getDateCreated() 
	{
		return dateCreated;
	}
	
	/**
	 * Setter for the Set creation date
	 * @param dateCreated - date of Set creation
	 */
	public void setDateCreated(Date dateCreated) 
	{
		this.dateCreated = dateCreated;
	}
	
	/**
	 * Getter for the last date of Set modification
	 * @return Set modification date
	 */
	public Date getDateUpdated() 
	{
		return dateUpdated;
	}
	
	/**
	 * Setter for the last date of Set modification
	 * @param dateUpdated - date of Set modification
	 */
	public void setDateUpdated(Date dateUpdated) 
	{
		this.dateUpdated = dateUpdated;
	}
	
	/**
	 * Getter for the isDeleted flag
	 * @return isDeleted flag
	 */
	public boolean isDeleted() 
	{
		return isDeleted;
	}
	
	/**
	 * Setter for the isDeleted flag
	 * @param isDeleted - flag to be set
	 */
	public void setDeleted(boolean isDeleted) 
	{
		this.isDeleted = isDeleted;
	}
	
	/**
	 * Getter for the set winner
	 * @return User who win the set
	 */
	public User getWinner() 
	{
		return winner;
	}
	
	/**
	 * Setter for set winner
	 * @param winner - user who win the set
	 */
	public void setWinner(User winner) 
	{
		this.winner = winner;
	}
	
	/**
	 * Getter for the set result
	 * @return result
	 */
	public int getResult() 
	{
		return result;
	}
	
	/**
	 * Setter for the set result
	 * @param result - result to be set
	 */
	public void setResult(int result) 
	{
		this.result = result;
	}
}

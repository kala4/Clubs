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

@Entity
@Table(name = "SETS")
public class Set 
{
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID")
	private Game game;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Column(name = "DATE_UPDATED")
	private Date dateUpdated;
	
	@Column(name = "IS_DELETED")
	private boolean isDeleted;
	
	@OneToOne
	@JoinColumn(name = "WINNER_ID", nullable=true, insertable=true, updatable=true, unique=false)
	private User winner;
	
	@Column(name = "RESULT")
	private int result;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public User getWinner() {
		return winner;
	}
	public void setWinner(User winner) {
		this.winner = winner;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}

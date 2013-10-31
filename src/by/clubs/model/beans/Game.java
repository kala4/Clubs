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

@Entity
@Table(name = "GAMES")
public class Game 
{
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private int m_id;
	
	@Column(name = "DATE_CREATED")
	private Date m_dateCreated;
	
	@Column(name = "DATE_UPDATED")
	private Date m_dateUpdated;
	
	@Column(name = "IS_DELETED")
	private boolean m_isDeleted;
	private List<User> m_players;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "GAMES")
	private List<Set> m_sets;
	
	@OneToOne
	@JoinColumn(name = "WINNER_ID", nullable=true, insertable=true, updatable=true, unique=false)
	private User m_winner;
	
	@Column(name = "RESULT")
	private int m_result;
	
	public int getId() {
		return m_id;
	}
	public void setId(int id) {
		this.m_id = id;
	}
	public List<User> getPlayers() {
		return m_players;
	}
	public void setPlayers(List<User> players) {
		this.m_players = players;
	}
	public List<Set> getSets() {
		return m_sets;
	}
	public void setSets(List<Set> sets) {
		this.m_sets = sets;
	}
	public User getWinner() {
		return m_winner;
	}
	public void setWinner(User winner) {
		this.m_winner = winner;
	}
	public int getResult() {
		return m_result;
	}
	public void setResult(int result) {
		this.m_result = result;
	}
	public Date getDateCreated() {
		return m_dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.m_dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return m_dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.m_dateUpdated = dateUpdated;
	}
	public boolean isDeleted() {
		return m_isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.m_isDeleted = isDeleted;
	}
}

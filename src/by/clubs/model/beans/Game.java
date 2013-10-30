package by.clubs.model.beans;

import java.util.Date;
import java.util.List;

public class Game 
{
	private int m_id;
	private Date m_dateCreated;
	private Date m_dateUpdated;
	private boolean m_isDeleted;
	private List<User> m_players;
	private List<Set> m_sets;
	private User m_winner;
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

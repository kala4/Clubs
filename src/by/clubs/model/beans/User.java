package by.clubs.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistence entity class which maps to the Users table in database
 * @author Aliaksei_Kalachou
 *
 */
@Entity
@Table(name = "USERS")
public class User 
{
	/** User ID */
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private int m_id;
	
	/** Date of user creation */
	@Column(name = "DATE_CREATED")
	private Date m_dateCreated;
	
	/** Date of user modification */
	@Column(name = "DATE_UPDATED")
	private Date m_dateUpdated;
	
	/** Flag for deleted user */
	@Column(name = "IS_DELETED")
	private boolean m_isDeleted;
	
	/** User first name */
	@Column(name = "FIRST_NAME")
	private String m_firstName;
	
	/** User last name */
	@Column(name = "LAST_NAME")
	private String m_lastName;
	
	/** User middle name */
	@Column(name = "MIDDLE_NAME")
	private String m_middleName;
	
	/** City Id */
	@Column(name = "SITY_ID")
	private Long m_cityId;
	
	/** User birthday */
	@Column(name = "BIRTHDAY")
	private Date m_birthday;
	
	/** User role */
	@Column(name = "ROLE_ID", nullable = true, unique = false)
	private Long m_roleId;
	
	/** User login */
	@Column(name = "LOGIN", nullable = false, unique = true)
	private String m_login;
	
	/** User password */
	@Column(name = "PASS", nullable = false, unique = false)
	private String m_password;
	
	/**
	 * Default constructor
	 */
	public User() 
	{
		super();
	}
	
	/**
	 * Constructor with parameters
	 * @param id - user id
	 * @param login - login
	 * @param password - password
	 */
	public User(int id, String login, String password) 
	{
		super();
		this.m_id = id;
		this.m_login = login;
		this.m_password = password;
	}

	/**
	 * Getter for user ID
	 * @return id
	 */
	public int getId() 
	{
		return m_id;
	}
	
	/**
	 * Setter for user ID
	 * @param id - new users id
	 */
	public void setId(int id) 
	{
		this.m_id = id;
	}
	
	/**
	 * Getter for dateCreated
	 * @return date when user was created
	 */
	public Date getDateCreated() 
	{
		return m_dateCreated;
	}
	
	/**
	 * Setter for dateCreated
	 * @param dateCreated - date when user was created
	 */
	public void setDateCreated(Date dateCreated) 
	{
		this.m_dateCreated = dateCreated;
	}
	
	/**
	 * Getter for dateUpdated
	 * @return date when user was updated
	 */
	public Date getDateUpdated() 
	{
		return m_dateUpdated;
	}
	
	/**
	 * Setter for dateUpdated
	 * @param dateUpdated - date when user was updated
	 */
	public void setDateUpdated(Date dateUpdated) 
	{
		this.m_dateUpdated = dateUpdated;
	}
	
	/**Getter for isDeleted
	 * @return true if user was deleted, false otherwise
	 */
	public boolean isDeleted() 
	{
		return m_isDeleted;
	}
	
	/**
	 * Setter for isDeleted
	 * @param isDeleted - flag to be set
	 */
	public void setDeleted(boolean isDeleted) 
	{
		this.m_isDeleted = isDeleted;
	}
	
	/**
	 * Getter for firstName
	 * @return firstName
	 */
	public String getFirstName() 
	{
		return m_firstName;
	}
	
	/**
	 * Setter for firstName
	 * @param firstName - new first name
	 */
	public void setFirstName(String firstName) 
	{
		this.m_firstName = firstName;
	}
	
	/**
	 * Getter for lastName
	 * @return lastName
	 */
	public String getLastName() 
	{
		return m_lastName;
	}
	
	/**
	 * Setter for the lastName
	 * @param lastName - new lastName
	 */
	public void setLastName(String lastName) 
	{
		this.m_lastName = lastName;
	}
	
	/**
	 * Getter for middleName
	 * @return middleName
	 */
	public String getMiddleName() 
	{
		return m_middleName;
	}
	
	/**
	 * Setter for middleName
	 * @param middleName - new middleName
	 */
	public void setMiddleName(String middleName) 
	{
		this.m_middleName = middleName;
	}
	
	/**
	 * Getter for cityId
	 * @return cityId
	 */
	public Long getCityId() 
	{
		return m_cityId;
	}
	
	/**
	 * Setter for cityId
	 * @param cityId - new cityId
	 */
	public void setCityId(Long cityId) 
	{
		this.m_cityId = cityId;
	}
	
	/**
	 * Getter for birthday
	 * @return birthday date
	 */
	public Date getBirthday() 
	{
		return m_birthday;
	}
	
	/**
	 * Setter for birthday
	 * @param birthday - new birthday
	 */
	public void setBirthday(Date birthday) 
	{
		this.m_birthday = birthday;
	}
	
	/**
	 * Getter for roleId
	 * @return roleId
	 */
	public Long getRoleId() 
	{
		return m_roleId;
	}
	
	/**
	 * Setter for roleId
	 * @param roleId - new roleId
	 */
	public void setRoleId(Long roleId) 
	{
		this.m_roleId = roleId;
	}
	
	/**
	 * Getter for login
	 * @return user login
	 */
	public String getLogin() 
	{
		return m_login;
	}
	
	/**
	 * Setter for login
	 * @param login - new login
	 */
	public void setLogin(String login) 
	{
		this.m_login = login;
	}
	
	/**
	 * Getter for password
	 * @return password
	 */
	public String getPassword() 
	{
		return m_password;
	}
	
	/**Setter for password
	 * @param password - new password
	 */
	public void setPassword(String password) 
	{
		this.m_password = password;
	}
}

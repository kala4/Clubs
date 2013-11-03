package by.clubs.ifaces;

import java.util.List;
import by.clubs.model.beans.User;
import by.clubs.utils.TheatreExeption;

/**
 * Interface for user DAO
 * @author Kalachev
 *
 */
public interface IUserDAO 
{
	
	/**
	 * Saves new User
	 * 
	 * @param user - User to be saved
	 * 
	 * @return void
	 * @throws TheatreExeption 
	 * 
 	 */
	public void createUser(User user) throws TheatreExeption;
	
	/**
	 * Gets id of User by specified login
	 * 
	 * @param user - User to be saved
	 * 
	 * @return id
	 * @throws TheatreExeption 
	 * 
 	 */
	public int getId(String name) throws TheatreExeption;
	
	/**
	 * Check if specified login is free to register new User
	 * 
	 * @param selectPst - User to be saved
	 * @param login - login to check
	 * 
	 * @return true - login is free, false - login is not free
	 * @throws TheatreExeption 
 	 */
	public boolean isLoginFree(String login) throws TheatreExeption;
	
	/**
	 * Performs user identification by specified login and password
	 * 
	 * @param login - User's login
	 * @param password - User's password
	 * 
	 * @return User or null
	 * @throws TheatreExeption 
	 * 
 	 */
	public User loginUser(String login, String password) throws TheatreExeption;
	
	/**
	 * Gets registered user by specified id
	 * 
	 * @param id - User's id
	 * 
	 * @return User or null
	 * @throws TheatreExeption 
	 * 
 	 */
	public User getUser(int id) throws TheatreExeption;

	/**
	 * returns size of all registered users
	 * @return long
	 * @throws TheatreExeption 
	 */
	public long getAllUsersSize() throws TheatreExeption;

	/**
	 * Gets size of users with specified role
	 * @param role - Role of users
	 * @return long
	 * @throws TheatreExeption 
	 */
//	public long getDefinedUsersSize(Role role);

	/**
	 * Gets list of users with specified role
	 * @param currentRole - users Role
	 * @param currentPage - number of page that should be returned from database
	 * @return List of users
	 * @throws TheatreExeption 
	 */
//	public List<User> getDefinedUsers(Role currentRole, int currentPage);

	/**
	 * Gets list of all users
	 * @param currentPage - number of page that should be returned from database
	 * @return List of users
	 * @throws TheatreExeption 
	 */
	public List<User> getAllUsers(int currentPage) throws TheatreExeption;

	/**
	 * Updated changes made with the user
	 * @param user - User that should be updated
	 * @throws TheatreExeption 
	 */
	public void updateUser(User user) throws TheatreExeption;

	/**
	 * Gets size of users marked as deleted
	 * @return long
	 * @throws TheatreExeption 
	 */
	public long getDeletedSize() throws TheatreExeption;

}

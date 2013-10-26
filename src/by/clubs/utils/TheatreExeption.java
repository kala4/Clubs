package by.clubs.utils;

import by.clubs.model.beans.User;

/**
 * The TheatreExeption is thrown when a checked exception occurs.
 * We use it to inform the user about what he is doing wrong.
 * @author Kalachev
 *
 */
public class TheatreExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6734359372623637139L;
	
	private User user;
	private String message;
	
	public TheatreExeption(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	}
	public TheatreExeption() {
		super();
	}
	public TheatreExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public TheatreExeption(String arg0) {
		super(arg0);
	}
	public TheatreExeption(Throwable arg0) {
		super(arg0);
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

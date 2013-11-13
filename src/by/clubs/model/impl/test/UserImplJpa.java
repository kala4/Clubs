package by.clubs.model.impl.test;

import java.util.ArrayList;
import java.util.List;

import by.clubs.ifaces.IUserDAO;
import by.clubs.model.beans.User;
import by.clubs.utils.TheatreExeption;

public class UserImplJpa implements IUserDAO{
	
	private List<User> users;
	
	public UserImplJpa() {
		users = new ArrayList<User>();
		users.add(new User(1, "Aliaksei", "123"));
		users.add(new User(2, "Andrei", "123"));
		users.add(new User(3, "Tamara", "123"));
		
	}

	@Override
	public void createUser(User user) throws TheatreExeption {
		users.add(user);
	}

	@Override
	public int getId(String name) throws TheatreExeption {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLoginFree(String login) throws TheatreExeption {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loginUser(String login, String password) throws TheatreExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int id) throws TheatreExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getAllUsersSize() throws TheatreExeption {
		return users.size();
	}

	@Override
	public List<User> getAllUsers(int currentPage) throws TheatreExeption {
		return users;
	}

	@Override
	public void updateUser(User user) throws TheatreExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getDeletedSize() throws TheatreExeption {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

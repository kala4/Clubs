package by.clubs.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import by.clubs.ifaces.IUserDAO;
import by.clubs.model.beans.User;
import by.clubs.model.factories.DAOFactory;
import by.clubs.utils.SeessionUtils;
import by.clubs.utils.TheatreExeption;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author kalachou
 *
 */
public class AddUserAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 6691592070065652199L;
	private String login;
	private String password;
	private String confirmedPassword;
	private Map<String, Object> session;
	private IUserDAO userDAO = (IUserDAO)DAOFactory.getDAO(Constants.USER_DAO);
	private static final Logger LOG = Logger.getLogger(AddUserAction.class);
	
	public String execute() {
		try {

			if (isInputInvalid()) {
				return Action.ERROR;
			}
			addActionMessage("user.login.registration.success");
			userDAO.createUser(new User(0, login, password));
			session.put(SeessionUtils.LOGINED_USER, userDAO.loginUser(login, password));
			return Action.SUCCESS;

		} catch (TheatreExeption e) {
			LOG.error(getText(Constants.EXEPTION_DAO));
			addActionError(getText(Constants.EXEPTION_DAO));
			return Action.ERROR;
		} 
	}

	private boolean isInputInvalid() throws TheatreExeption {
		if (login==null || login.trim().length()==0) 
		{
			addActionError(getText("error.login.emty"));
			return true;
		} 
		else if (password==null || password.trim().length()==0) 
		{
			addActionError(getText("error.login.emty"));
			return true;
		}else if (!password.equals(confirmedPassword)) 
		{
			addActionError(getText("error.login.passwords.confirm.missmuch"));
			return true;
		}
//		else if (!userDAO.isLoginFree(login)) 
//		{
//			addActionError(getText("error.login.exists"));
//			return true;
//		}
		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

}

package by.clubs.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import by.clubs.ifaces.IUserDAO;
import by.clubs.model.beans.User;
import by.clubs.model.factories.DAOFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
//	private static final long serialVersionUID = -8977225521281127983L;
	private String username;
	private String password;
	private Map<String, Object> session;
	private static final Logger LOG = Logger.getLogger(LoginAction.class);
	
	private static final String KEY_USER = "user";

	private static final String ERROR_FIELDS_ABSCENT = "error_fields_abscent";
	private static final String ERROR_LOGIN_NO_USER = "error_login_no_user";
	private static final String LOGIN_USER_DELETED = "login.user.deleted";
	private static final String LOGIN_SUCCESSFUL = "login.successful";

	public String execute() {
		try {
			if (isInvalid(getUsername())) {
				addActionError(getText(ERROR_FIELDS_ABSCENT));
				return Action.INPUT;
			}
			if (isInvalid(getPassword())) {
				addActionError(getText(ERROR_FIELDS_ABSCENT));

				return Action.INPUT;
			}
			IUserDAO userDAO = (IUserDAO) DAOFactory.getDAO(Constants.USER_DAO); 
			User user = userDAO.loginUser(username, password);

			if (user!=null) {
				if (user.isDeleted()) {
					addActionError(LOGIN_USER_DELETED);
				}
				addActionMessage(LOGIN_SUCCESSFUL);
				session.put(KEY_USER, user);
				return Action.SUCCESS;
			} else {
				addActionError(getText(ERROR_LOGIN_NO_USER));
				return Action.INPUT;
			}
		} catch (Exception e) {
			LOG.error(getText(Constants.EXEPTION_DAO));
			addActionError(getText(Constants.EXEPTION_DAO));
			return Action.ERROR;
		}
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

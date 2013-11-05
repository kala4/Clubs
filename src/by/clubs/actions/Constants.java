package by.clubs.actions;

import by.clubs.ifaces.IGameDAO;
import by.clubs.ifaces.IUserDAO;


/**
 * @author Kalachev
 *
 */
public interface Constants {
	
	String USER_DAO = IUserDAO.class.getName();
	String GAME_DAO = IGameDAO.class.getName();
	
	
	String EXEPTION_DAO = "dao.exeption";
	String EXEPTION_ADDRESS_BAR = "address.bar.exeption";
	
	int PAGE_SIZE = 5;
	String CURRENT_PAGE = "currentPage";
	String PAGES = "pages";
	
	String USERS = "users";
	String USERS_ALL_SIZE = "allUsersSize";
	String USERS_GUEST_ROLE_SIZE = "roleGuestSize";
	String USERS_USER_ROLE_SIZE = "roleUsersSize";
	String USERS_COURIER_ROLE_SIZE = "roleCourierSize";
	String USERS_ADMIN_ROLE_SIZE = "roleAdminSize";
	
	String NO_USER = "no.user";
	
}

package by.clubs.actions;

import by.clubs.ifaces.IUserDAO;


/**
 * @author Kalachev
 *
 */
public interface Constants {
	String PLAYS = "plays";
	String SCHEDULES = "schedules";

//	String SCHEDULE_DAO = IScheduleDAO.class.getName();
//	String PLAY_DAO = IPlayDAO.class.getName();
	String USER_DAO = IUserDAO.class.getName();
//	String SEAT_DAO = ISeatDAO.class.getName(); 
//	String ORDER_DAO = IOrderDAO.class.getName(); 
	
	String ROLE_ADMIN = "ADMIN";
	String ROLE_COURIER = "COURIER";
	String ROLE_GUEST = "GUEST";
	String ROLE_USER = "USER";
	
	String STATUS_ORDERED = "ORDERED";
	String STATUS_CANCELLED = "CANCELLED";
	String STATUS_PAID = "PAID";
	
	int MAX_SEATS_NUMBER = 60;

	String NO_PLAY = "no.play";

	String PLAY_INFO = "play";

	String AVAILABLE_PORTER_SEATS = "availableSeats";
	
	String AVAILABLE_SEATS_PORTER = "availableSeatsPorter";
	String AVAILABLE_SEATS_LOGGIA = "availableSeatsLoggia";

	String USER_ORDERED_SEATS = "userOrderedSeats";

	String SEAT_NUMBER = "seatNumber";
	String CANCEL_ORDER= "cancelOrder";

	String NO_SEAT = "no.seat";

	String JUST_ORDERED = "just.ordered";
	String NO_ORDER = "no.order";
	String ORDER_JUST_CHANGED = "just.changed";
	String NOT_YOUR_ORDER = "not.your.order";

	String MY_ORDERS = "myOrders";

	String ORDER_ID = "orderId";

	String ORDERS_ALL = "allOrders";

	String ORDERS_UNPAID = "unPaidOrders";
	
	String EXEPTION_DAO = "dao.exeption";
	String EXEPTION_ADDRESS_BAR = "address.bar.exeption";
	
	int PAGE_SIZE = 5;
	String CURRENT_PAGE = "currentPage";
	String PAGES = "pages";
	String SCHEDULE = "schedule";
	String MY_BASKET = "myBasket";
	String ORDERS_IN_BASKET = "ordersInBasket";
	
	String USERS = "users";
	String USERS_ALL_SIZE = "allUsersSize";
	String USERS_GUEST_ROLE_SIZE = "roleGuestSize";
	String USERS_USER_ROLE_SIZE = "roleUsersSize";
	String USERS_COURIER_ROLE_SIZE = "roleCourierSize";
	String USERS_ADMIN_ROLE_SIZE = "roleAdminSize";
	
	String NO_USER = "no.user";
	String USERS_DELETED_SIZE = "deletedUsersSize";
	String DATES = "dates";
	String SCHEDULE_SAVED = "schedule.saved";
	String PLAY_SAVED = "play.saved";

	
}

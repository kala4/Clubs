package by.clubs.model.impl;

/**
 * @author Kalachev
 *
 */
public interface ConstantsJpa {
	
	String GET_USER_APPROVED_ORDERS = "SELECT o FROM Order o WHERE o.user = ? AND o.orderStatus <> ?";
	String GET_USER_APPROVED_ORDERS_COUNT = "SELECT COUNT(o) FROM Order o WHERE o.user = ? AND o.orderStatus <> ?";
	String GET_ALL_USER_ORDERS = "SELECT o FROM Order o WHERE o.user = ?";
	String GET_USER_PLAY_ORDERS = "SELECT o FROM Order o WHERE o.user = ? AND o.schedule.play = ? AND o.schedule.date = ?";
	String GET_PLAY_ORDERS = "SELECT o FROM Order o WHERE o.schedule.play = ? AND o.schedule.date = ?";
	String IS_SEAT_FREE = "SELECT o FROM Order o WHERE o.schedule.play = ? AND o.seat=? AND o.schedule.date=?";
	String GET_ORDER_BY_ID = "SELECT o FROM Order o WHERE o.id = ?";
	String GET_APPROVED_ORDERS = "SELECT o FROM Order o WHERE o.orderStatus <> ?";
	String GET_APPROVED_ORDERS_COUNT = "SELECT COUNT(o) FROM Order o WHERE o.orderStatus <> ?";
	String GET_DEFINED_ORDERS = "SELECT o FROM Order o WHERE o.orderStatus = ?";
	String GET_DEFINED_ORDERS_COUNT = "SELECT COUNT(o) FROM Order o WHERE o.orderStatus = ?";
	String GET_USER_DEFINED_ORDERS = "SELECT o FROM Order o WHERE o.orderStatus = ? AND o.user = ?";
	String GET_USER_DEFINED_ORDERS_COUNT = "SELECT COUNT(o) FROM Order o WHERE o.orderStatus = ? AND o.user = ?";
	
	String GET_PLAYS = "SELECT p FROM Play p";
	String FIND_PLAY_BY_ID = "SELECT p FROM Play p WHERE p.id = ?";
	String IS_PLAY_EXISTS = "SELECT p.name FROM Play p WHERE p.name = ?";
	
	String GET_SCHEDULES = "SELECT s FROM Schedule s WHERE s.date >= ? ORDER BY s.date";
	String GET_SCHEDULES_COUNT = "SELECT COUNT(s) FROM Schedule s WHERE s.date >= ? ORDER BY s.date";
	String FIND_SCHEDULE = "SELECT s FROM Schedule s WHERE s.play = ? AND s.date = ?";
	
	String GET_SEATS = "SELECT s FROM Seat s";
	String GET_SEAT_BY_NUMBER = "SELECT s FROM Seat s WHERE s.number = ?";
	String GET_SEATS_BY_CATEGORY = "SELECT s FROM Seat s WHERE s.catecogy = ?";
	
	String GET_USER_ID = "SELECT u.id FROM User u WHERE u.login = ?";
	String IS_LOGIN_FREE = "SELECT u.login FROM User u WHERE u.login = ?";
	String LOGIN_USER = "SELECT u FROM User u WHERE u.m_login = ? AND u.m_password = ?";
	String GET_USER = "SELECT u FROM User u WHERE u.id = ?";
	String GET_ALL_USERS = "SELECT u FROM User u ORDER BY u.login";
	String GET_ALL_USERS_COUNT = "SELECT COUNT(u) FROM User u ORDER BY u.login";
	String GET_DEFINED_USERS = "SELECT u FROM User u WHERE u.role = ?";
	String GET_DEFINED_USERS_COUNT = "SELECT COUNT(u) FROM User u WHERE u.role = ?";
	String GET_DELETED_USERS = "SELECT u FROM User u WHERE u.isDeleted = true";
	String GET_DELETED_USERS_COUNT = "SELECT COUNT(u) FROM User u WHERE u.isDeleted = true";
	String GET_ORDERS_FROM_PERIOD = "SELECT o FROM Order o WHERE o.schedule.date>=? AND o.schedule.date<=?";
	String GET_ORDERS_FROM_PERIOD_FOR_REPORT = "SELECT o.id AS id, o.user.login AS login FROM Order o WHERE o.schedule.date>=? AND o.schedule.date<=?";
	
	String GET_GAMES_LIST = "SELECT g FROM Game g ORDER BY g.dateCreated";
}

package by.clubs.model.factories;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kalachev
 *
 */
public class DAOFactory {
	private static Map<String, Object> map = new HashMap<String, Object>();
	
	static{
		
//		map.put(IUserDAO.class.getName(), new UserImplJpa());
//		map.put(ISeatDAO.class.getName(), new SeatImplJpa());
//		map.put(IOrderDAO.class.getName(), new OrderImplJpa());
//		map.put(IPlayDAO.class.getName(), new PlayImplJpa());
//		map.put(IScheduleDAO.class.getName(), new ScheduleImplJpa());
	}

	/**
	 * Gets the dao.
	 * 
	 * @param className Name of DAO interface
	 * 
	 * @return DAO class
	 */
	public static Object getDAO(String className) {
		return map.get(className);
		
	}
}

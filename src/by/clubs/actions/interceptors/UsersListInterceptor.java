package by.clubs.actions.interceptors;

import java.util.List;
import java.util.Map;

import by.clubs.actions.Constants;
import by.clubs.ifaces.IUserDAO;
import by.clubs.model.beans.User;
import by.clubs.model.factories.DAOFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UsersListInterceptor extends AbstractInterceptor
{

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception
    {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        int currentPage = 1;// should be rewritten
        
        IUserDAO userDAO = (IUserDAO) DAOFactory.getDAO(Constants.USER_DAO);
        List<User> users = userDAO.getAllUsers(currentPage);
        session.put(Constants.USERS, users);
        return actionInvocation.invoke();
    }

}

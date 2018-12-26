package homeProject.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import homeProject.Roles;
import homeProject.User;
import homeProject.dao.BasicDao;
import homeProject.dao.UserDao;
import homeProject.service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService{
	@Autowired
	private UserDao userDao;
	
		
	@Override
	public BasicDao<User> getMainDao() {
		return userDao;
	}

	
	public void addRole(int userID, List<Roles> roles) {
		User user = userDao.findById(userID);
		user.setRoles(roles);
		userDao.update(user);
		
	}

}

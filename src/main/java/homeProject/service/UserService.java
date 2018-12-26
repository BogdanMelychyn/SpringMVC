package homeProject.service;

import java.util.List;

import homeProject.Roles;
import homeProject.User;

public interface UserService extends BasicService<User>{

	void addRole(int userID, List<Roles> roles); 
}

package homeProject.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import homeProject.Roles;
import homeProject.User;
import homeProject.service.UserService;

@Service("customAuthenticationProvider")
public class CustomSecurityProvider implements AuthenticationProvider {
	@Autowired
	private UserService userServ;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		List<User> userList = userServ.findByProperty("login", username);
		if (userList.isEmpty()){
			return null;
		}
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		User u = userList.get(0);
		if (u.getPassword().equals(password)) {
			System.out.println(password);
			System.out.println(username);
			List<Roles> listRole = u.getRoles();
			for (Roles r : listRole) {
				System.out.println(r.name());
				roles.add(new SimpleGrantedAuthority(r.name()));

			}

			System.out.println("Authenticate");

			return new UsernamePasswordAuthenticationToken(username, password, roles);
		} else return null;

	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}

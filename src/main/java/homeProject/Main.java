package homeProject;

import java.util.List;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import homeProject.service.CarService;
import homeProject.service.DriverService;
import homeProject.service.UserService;
import homeProject.service.impl.CarServiceImpl;
import homeProject.service.impl.DriverServiceImpl;
import homeProject.service.impl.UserServiceImpl;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		UserService us = (UserService) context.getBean(UserServiceImpl.class);
		DriverService ds = (DriverService) context.getBean(DriverServiceImpl.class);
		//System.out.println(ds.findByProperty("name", "Pol"));
		List<User> list =us.findByProperty("login", "admin");
		
			User user = list.get(0);
			System.out.println(user);
			System.out.println(user.getRoles());
			
		
		
		
//		List<Roles> role = new ArrayList<Roles>();
//		role.add(Roles.ROLE_ADMIN);
//		role.add(Roles.ROLE_USER);
//		role.add(Roles.ROLE_GUEST);
//				
//		us.addRole(2, role);
		
		CarService cs = (CarService) context.getBean(CarServiceImpl.class);
		Driver d = ds.findById(1);
		System.out.println(d);
		Car c = new Car("12545", "Volvo");
		c.setDriver(d);
		System.out.println(d.getCars()+"--"+c.getDriver());
		ds.update(d);
//		Driver d2 = new Driver("Mark", "28", "sasafsd@asd.net");
		
		Car c2 = new Car("12785", "BMW");
		c2.setDriver(d);
		Car c3 = new Car("77712", "Kia");
		c3.setDriver(d);
//		Car c4 = new Car(772, "WWW");
	
		//cs.insert(c2);
//		ds.insert(d2);
//		System.out.println(ds.findAll());
//		System.out.println(cs.findAll());
		context.close();
	}

}

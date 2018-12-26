package homeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import homeProject.Car;
import homeProject.Driver;
import homeProject.service.DriverService;

@Controller
public class DriverController {
	@Autowired
	private DriverService dS;

	@RequestMapping(value = "/showAll")
	public String getAllDrivers(Model model) {
		List<Driver> list = dS.findAll();
		model.addAttribute("drivers", list);
		return "drivers";

	}
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/createDriver")
	public String createPage() {
		return "newDriver";
		
	}
	
	@RequestMapping(value = "/newD", method = RequestMethod.POST)
	public String creatingDriver(Model model, @RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age, @RequestParam(value = "eMail") String eMail) {
		Driver d = new Driver(name, Integer.parseInt(age), eMail);
		dS.insert(d);
		return "redirect:/showAll";
	}

	@RequestMapping(value = "/dInfo", method = RequestMethod.GET)
	public String showDriverInfo(Model model, @RequestParam(value = "id") int id) {
		Driver d = dS.findById(id);
		List<Car> listCar = d.getCars();
		model.addAttribute("ainf", d);
		model.addAttribute("cars", listCar);
		return "driverInfo";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit_driver", method = RequestMethod.GET)
	public String driverUpdate(Model model, @RequestParam(value = "id") int id) {
		Driver d = dS.findById(id);
		model.addAttribute("driver", d);
		return "driverUpdatePage";
	}
	
	@RequestMapping(value = "/driver_update", method = RequestMethod.POST)
	public String updatingDriver(Model model, @RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age, @RequestParam(value = "eMail") String eMail) {
		Driver d = dS.findById(Integer.parseInt(id));
		d.setAge(Integer.parseInt(age));
		d.setName(name);
		d.setEmail(eMail);
		dS.update(d);
		return "redirect:/dInfo?id=" + id;
	}

	
	
	
	
	
	
	
	
	
	
}

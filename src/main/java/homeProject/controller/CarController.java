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
import homeProject.service.CarService;
import homeProject.service.DriverService;


@Controller
public class CarController {
	@Autowired
	private CarService cS;
	@Autowired
	private DriverService dS;
	
	
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/newCarForm")
	public String newCarForm(Model model) {
		List<Driver> listDriver = dS.findAll();
		model.addAttribute("drivers", listDriver);
		return "newCarPage";
	}
	
	@RequestMapping(value = "/newCar", method = RequestMethod.POST)
	public String createCar(Model model, @RequestParam(value = "carBrend") String carBrend,
			@RequestParam(value = "carN") String carN,
			@RequestParam(value = "driverId") String dId) {
		Driver d = dS.findById(Integer.parseInt(dId));
		Car c = new Car(carN, carBrend);
		c.setDriver(d);
		
		dS.update(d);
		return "redirect:/newCarForm";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit_car", method = RequestMethod.GET)
	public String carUpdate(Model model, @RequestParam(value = "carId") String id) {
		Car car = cS.findById( Integer.parseInt(id));
		model.addAttribute("car", car);
		return "carUpdatePage";
		
	}
	@RequestMapping(value = "/update_car", method = RequestMethod.POST)
	public String updatingCar(Model model, @RequestParam(value = "carBrend") String carBrend,
			@RequestParam(value = "carN") String carN,
			@RequestParam(value = "carId") String cId) {
		Car c = cS.findById(Integer.parseInt(cId));
		c.setCarBrand(carBrend);
		c.setCarNumber(carN);
		cS.update(c);
		return "redirect:/dInfo?id=" + c.getDriver().getId();
	}


}

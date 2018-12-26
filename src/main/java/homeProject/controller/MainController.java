package homeProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/main")
	public String goToWelcome() {

		return "main";
	}

	@RequestMapping(value = "/Logerr")
	public String goToLoginErr(Model model) {
		model.addAttribute("err", "Bad Login or Password");
		return "authfail";
	}
	
}

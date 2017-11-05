package pl.klusek.Vegapi.controllers.backofficeController;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.klusek.Vegapi.database.LocalRepository;
import pl.klusek.Vegapi.models.Local;

@EnableWebSecurity
@Controller
public class BackofficeFunctionsController {

    private final Logger logger = LoggerFactory.getLogger(BackofficeFunctionsController.class);

    @Autowired
    LocalRepository lokalRepo;
    
	@GetMapping("/dodajLokal")
	public String dodajLokal(Model model) {
		Local lokal = new Local();
		model.addAttribute("lokal", lokal);
		return "dodajLokal";
	}
	
	@PostMapping("/dodajLokal")
	public String postDodajLokal(@ModelAttribute("lokal") Local lokal, HttpServletRequest req) {	
		try {
			
			logger.info("nazwaLokalu" + lokal.getName());
			lokalRepo.save(lokal);
			
		}catch (Exception e) {
			logger.error("Blad podczas dodawania lokalu", e);
		}
		return "redirect:/lokale";
	}
	
}

package pl.klusek.Vegapi.controllers.backofficeController;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pl.klusek.Vegapi.models.user.User;

@EnableWebSecurity

@Controller
public class BackofficeController {

    private final Logger logger = LoggerFactory.getLogger(BackofficeController.class);
    
	@GetMapping("/panel")
	public String test(Model model) {
		
		return "backofficeMainPanel";
	}
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error, HttpServletRequest req) {
		
		if (error!=null) {
			model.addAttribute("message", "Błędna próba logowania");
		}
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
		
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute("user") User user, Model model, HttpServletRequest req, RedirectAttributes redirectAttrs) {
		logger.info("jestem w poście");
		Enumeration <String> enum1 = req.getAttributeNames();
		logger.info("enum list " + enum1.toString());
		logger.info("kontekst paf "+req.getContextPath());
		logger.info("3" + req.getParameter("error"));
		
		redirectAttrs.addAttribute("user", user);
		
		return "redirect:/panel";
	}
	
	@GetMapping("/logout")
	public String logoutPage (HttpServletRequest req, HttpServletResponse resp, Model model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(req, resp, auth);
		    }
		model.addAttribute("message", "Wylogowano poprawnie");
		return "login";
	}
}

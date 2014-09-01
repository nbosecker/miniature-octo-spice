package com.bosecker.tm.signup;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bosecker.tm.account.*;
import com.bosecker.tm.support.web.*;

@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/signup";

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
		
	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}
		Account account = accountRepository.save(signupForm.createAccount(), signupForm.createTmStudent());
		userService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
        
        if (account.getRole() == "ROLE_ADMIN")
        {
        	System.out.print("THIS IS ADMIN SIGNUP");
        	return "redirect:/admin";
        }
        else 
        {
        	System.out.print("THIS IS USER SIGNUP");
        	return "redirect:/user";
        }
	}
	
	@RequestMapping(value = "reset")
	public String passwordReset(Model model) {
		model.addAttribute(new PasswordResetForm());
        return "passwordReset/passwordReset";
	}
	
	@RequestMapping(value = "reset", method = RequestMethod.POST)
	public String passwordReset(@Valid @ModelAttribute PasswordResetForm passwordResetForm, Errors errors, RedirectAttributes ra,
			ModelMap modelMap) {
		if (errors.hasErrors()) {
			return "passwordReset/passwordReset";
		}
		
		// Verify the current credentials are correct. If not, return error and don't change password.
		UserDetails userDetails = userService.loadUserByUsername(passwordResetForm.getInputEmail());
		if ( !passwordEncoder.matches(passwordResetForm.getInputPassword(), userDetails.getPassword())){
			modelMap.addAttribute("errorMessage", "Invalid password entered, password will not be reset.");
			return "passwordReset/passwordReset";
		}
 	     
		else {
			// Reset password as directed and redirect to signin screen.
			Account acc = accountRepository.findByEmail(userDetails.getUsername());
			
			acc.setPassword(passwordResetForm.getPasswordNew1());
			accountRepository.save(acc);
			
			modelMap.addAttribute("confirmationMessage", "Password successfully changed! Please sign in.");
			
		}
		
		return "signin/signin";
		
	}
}

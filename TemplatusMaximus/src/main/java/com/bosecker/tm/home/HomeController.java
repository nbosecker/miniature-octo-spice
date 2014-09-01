package com.bosecker.tm.home;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bosecker.tm.account.Account;
import com.bosecker.tm.account.AccountRepository;
import com.bosecker.tm.account.TmStudent;
import com.bosecker.tm.account.TmStudentRepository;
import com.bosecker.tm.signup.SignupForm;

@Controller
public class HomeController {

	private TmStudentRepository tmStudentRepository;
	
	private AccountRepository accountRepository;

    @Autowired
    public HomeController(TmStudentRepository tmStudentRepository, AccountRepository accountRepository) {
        this.tmStudentRepository = tmStudentRepository;
        this.accountRepository = accountRepository;
    }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		if ( principal != null ) {
			Account account = accountRepository.findByEmail(principal.getName());
			TmStudent tmStudent = tmStudentRepository.findTmStudentById(account.getId());
			if ( tmStudent != null ){
				model.addAttribute("user", tmStudent);
			}
		}
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
	
	@RequestMapping(value = "/students.json", method = RequestMethod.GET)
	public @ResponseBody String exampleTerritories(){
				
		List<TmStudent> studentList = tmStudentRepository.findAll();
				
		ObjectMapper objMapper = new ObjectMapper(); // can reuse, share globally
		String mapAsJson = null;
		try {
			mapAsJson = objMapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapAsJson;
	}
	
	@RequestMapping(value = "/teststudents.json", method = RequestMethod.GET)
	public @ResponseBody String testStudentsJson(){
				
		List<TmStudent> studentList = tmStudentRepository.findAllTestUsers();
				
		ObjectMapper objMapper = new ObjectMapper(); // can reuse, share globally
		String mapAsJson = null;
		try {
			mapAsJson = objMapper.writeValueAsString(studentList);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapAsJson;
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/leaderboard", method = RequestMethod.GET)
    public String leaderboard(Principal principal, Model model) {
		
    	Account account = accountRepository.findByEmail(principal.getName());
		TmStudent tmStudent = tmStudentRepository.findTmStudentById(account.getId());
		List<TmStudent> studentList = null;
		if ( tmStudent.isAdmin())
		{
			studentList = tmStudentRepository.findAll();
	    	Collections.sort(studentList);
		}
		else if ( tmStudent.isTestAdmin())
		{
			studentList = tmStudentRepository.findAllTestUsers();
	    	Collections.sort(studentList);
		}
		
    	model.addAttribute("students", studentList);
		
    	return "home/leaderboard";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/narrative1", method = RequestMethod.GET)
    public String narrative(Principal principal, Model model) {
		
    	
		
    	return "home/narrative1";
    }
}

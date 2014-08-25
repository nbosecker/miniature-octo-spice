package com.bosecker.tm.home;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "home/homeUserSignedIn" : "home/homeNotSignedIn";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String indexUser(Principal principal) {
		return principal != null ? "home/homeUserSignedIn" : "home/homeNotSignedIn";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String indexAdmin(Principal principal) {
		return principal != null ? "home/homeAdminSignedIn" : "home/homeNotSignedIn";
	}
	
	@RequestMapping(value = "/admin/updateuser", method = RequestMethod.GET)
	public String updateUser() {
		return "home/updateuser";
	}
	
	@RequestMapping(value = "/examples/territories.json", method = RequestMethod.GET)
	public @ResponseBody String exampleTerritories(){
				
		Map aMap = new HashMap();
		aMap.put("alias", "Ninja_Joe");
		aMap.put("firstName", "Joe");
		aMap.put("lastName", "Student");
		aMap.put("hw1", 93);
		aMap.put("hw2", 94);
		aMap.put("hw3", 95);
		aMap.put("hw4", 96);
		aMap.put("hw5", 97);
		aMap.put("midterm", 98);
		aMap.put("thefinal", 99);
		aMap.put("participation", 40);
		aMap.put("id", 1);
				
		ObjectMapper objMapper = new ObjectMapper(); // can reuse, share globally
		String mapAsJson = null;
		try {
			mapAsJson = objMapper.writeValueAsString(aMap);
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
	
	@RequestMapping(value = "/examples/nancyuser", method = RequestMethod.GET)
	public @ResponseBody String nancyTest(){
		return null;
	}
}

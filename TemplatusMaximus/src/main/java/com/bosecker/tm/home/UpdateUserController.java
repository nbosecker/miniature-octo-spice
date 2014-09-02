package com.bosecker.tm.home;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.bosecker.tm.account.AccountRepository;
import com.bosecker.tm.account.TmStudent;
import com.bosecker.tm.account.TmStudentRepository;
import com.bosecker.tm.home.UpdateUserForm;

@Controller
public class UpdateUserController {

	private TmStudentRepository tmStudentRepository;

    @Autowired
    public UpdateUserController(TmStudentRepository tmStudentRepository) {
        this.tmStudentRepository = tmStudentRepository;
    }

    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.GET)
	public String nancyTest(@PathVariable(value="id") Long id, Model model) {
		
    	TmStudent tmStudent = tmStudentRepository.findTmStudentById(id);
    	
		UpdateUserForm formObject = new UpdateUserForm();
    	formObject.setId(tmStudent.getId());
    	formObject.setFirstName(tmStudent.getFirstName());
    	formObject.setLastName(tmStudent.getLastName());
    	formObject.setCharacterName(tmStudent.getCharacterName());
    	formObject.setHasBadge1(tmStudent.isBadge1());
    	formObject.setHasBadge2(tmStudent.isBadge2());
    	formObject.setHasBadge3(tmStudent.isBadge3());
    	formObject.setHasBadge4(tmStudent.isBadge4());
    	formObject.setHasBadge5(tmStudent.isBadge5());
    	formObject.setHasBadge6(tmStudent.isBadge6());
    	formObject.setHw1(tmStudent.getHw1());
    	formObject.setHw2(tmStudent.getHw2());
    	formObject.setHw3(tmStudent.getHw3());
    	formObject.setHw4(tmStudent.getHw4());
    	formObject.setHw5(tmStudent.getHw5());
    	formObject.setMidtermExam(tmStudent.getMidterm());
    	formObject.setFinalExam(tmStudent.getThefinal());
    	formObject.setParticipation(tmStudent.getParticipation());
		
    	model.addAttribute("updateUserForm",formObject);
		
    	return "home/updateuser";
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute UpdateUserForm updateUserForm, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "home/updateuser";
		}
		
		model.addAttribute("updateUserForm",updateUserForm);
		
		TmStudent tmStudent = tmStudentRepository.findTmStudentById(updateUserForm.getId());
		tmStudent.setFirstName(updateUserForm.getFirstName());
		tmStudent.setLastName(updateUserForm.getLastName());
		tmStudent.setCharacterName(updateUserForm.getCharacterName());
		tmStudent.setBadge1(updateUserForm.isHasBadge1());
		tmStudent.setBadge2(updateUserForm.isHasBadge2());
		tmStudent.setBadge3(updateUserForm.isHasBadge3());
		tmStudent.setBadge4(updateUserForm.isHasBadge4());
		tmStudent.setBadge5(updateUserForm.isHasBadge5());
		tmStudent.setBadge6(updateUserForm.isHasBadge6());
		tmStudent.setHw1(updateUserForm.getHw1());
		tmStudent.setHw2(updateUserForm.getHw2());
		tmStudent.setHw3(updateUserForm.getHw3());
		tmStudent.setHw4(updateUserForm.getHw4());
		tmStudent.setHw5(updateUserForm.getHw5());
		tmStudent.setMidterm(updateUserForm.getMidtermExam());
		tmStudent.setThefinal(updateUserForm.getFinalExam());
		tmStudent.setParticipation(updateUserForm.getParticipation());
		
		tmStudent.setFinalGrade(tmStudent.calculateFinalGrade());
		
		tmStudentRepository.save(tmStudent);
		
		return "redirect:/";
	}
}

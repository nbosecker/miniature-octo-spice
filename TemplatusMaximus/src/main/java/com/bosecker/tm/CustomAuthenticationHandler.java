package com.bosecker.tm;

import java.io.Console;
import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bosecker.tm.account.Account;
import com.bosecker.tm.account.AccountRepository;
import com.bosecker.tm.account.TmStudent;
import com.bosecker.tm.account.TmStudentRepository;

public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler 
{
	@Qualifier("accountRepository")
    @Autowired
    private AccountRepository accountRepository;

	@Qualifier("tmStudentRepository")
    @Autowired
    private TmStudentRepository tmStudentRepository;

	private AuthenticationSuccessHandler target = new SavedRequestAwareAuthenticationSuccessHandler();

	 @Override
	 public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException 
	 {
			 Account account = accountRepository.findByEmail(authentication.getName());
			 TmStudent tmStudent = tmStudentRepository.findTmStudentById(account.getId());
		 	 if ( tmStudent != null ){
				
		 			request.getSession().setAttribute("user", tmStudent);
		 			getRedirectStrategy().sendRedirect(request, response, "/");
		 		}
			
		      else{
		    	  request.getSession().setAttribute("user", null);
		         target.onAuthenticationSuccess(request, response, authentication);
		         return;
		      }
	}
	 
}

package com.bosecker.tm.signup;

import org.hibernate.validator.constraints.*;

import com.bosecker.tm.account.Account;
import com.bosecker.tm.account.TmStudent;

@FieldMatch(first = "passwordNew2", second = "passwordNew1", message = "The password fields must match")
public class PasswordResetForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

	@NotBlank(message = PasswordResetForm.NOT_BLANK_MESSAGE)
	@Email(message = PasswordResetForm.EMAIL_MESSAGE)
	private String inputEmail;
    
	@NotBlank(message = PasswordResetForm.NOT_BLANK_MESSAGE)
	private String inputPassword;
    
    @NotBlank(message = PasswordResetForm.NOT_BLANK_MESSAGE)
	private String passwordNew1;
    
    @NotBlank(message = PasswordResetForm.NOT_BLANK_MESSAGE)
	private String passwordNew2;

	public String getInputEmail() {
		return inputEmail;
	}



	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}



	public String getInputPassword() {
		return inputPassword;
	}



	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}


	public String getPasswordNew1() {
		return passwordNew1;
	}

	public void setPasswordNew1(String passwordNew1) {
		this.passwordNew1 = passwordNew1;
	}

	public String getPasswordNew2() {
		return passwordNew2;
	}

	public void setPasswordNew2(String passwordNew2) {
		this.passwordNew2 = passwordNew2;
	}
    
    
    
}

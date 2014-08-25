package com.bosecker.tm.signup;

import org.hibernate.validator.constraints.*;

import com.bosecker.tm.account.Account;
import com.bosecker.tm.account.TmStudent;

public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	@Email(message = SignupForm.EMAIL_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String firstName;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String lastName;

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account createAccount() {
        return new Account(getEmail(), getPassword(), "ROLE_ADMIN");
	}
	
	public TmStudent createTmStudent() {
        return new TmStudent(getFirstName(), getLastName());
	}
}

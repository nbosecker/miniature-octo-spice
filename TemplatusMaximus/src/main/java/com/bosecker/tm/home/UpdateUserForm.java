package com.bosecker.tm.home;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.bosecker.tm.account.TmStudent;

public class UpdateUserForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

	private Long id;

	@NotBlank(message = UpdateUserForm.NOT_BLANK_MESSAGE)
	private String firstName;
    
    @NotBlank(message = UpdateUserForm.NOT_BLANK_MESSAGE)
	private String lastName;
    
    @NotBlank(message = UpdateUserForm.NOT_BLANK_MESSAGE)
	private String characterName;
    
    private Double hw1;
    private Double hw2;
    private Double hw3;
    private Double hw4;
    private Double hw5;
    
    private boolean hasBadge1;
    private boolean hasBadge2;
    private boolean hasBadge3;
    private boolean hasBadge4;
    private boolean hasBadge5;
    private boolean hasBadge6;
    
    private Double midtermExam;
    private Double finalExam;
    private Double participation;
    

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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Double getHw1() {
		return hw1;
	}

	public void setHw1(Double hw1) {
		this.hw1 = hw1;
	}

	public Double getHw2() {
		return hw2;
	}

	public void setHw2(Double hw2) {
		this.hw2 = hw2;
	}

	public Double getHw3() {
		return hw3;
	}

	public void setHw3(Double hw3) {
		this.hw3 = hw3;
	}

	public Double getHw4() {
		return hw4;
	}

	public void setHw4(Double hw4) {
		this.hw4 = hw4;
	}

	public Double getHw5() {
		return hw5;
	}

	public void setHw5(Double hw5) {
		this.hw5 = hw5;
	}

	public boolean isHasBadge1() {
		return hasBadge1;
	}

	public void setHasBadge1(boolean hasBadge1) {
		this.hasBadge1 = hasBadge1;
	}

	public boolean isHasBadge2() {
		return hasBadge2;
	}

	public void setHasBadge2(boolean hasBadge2) {
		this.hasBadge2 = hasBadge2;
	}

	public boolean isHasBadge3() {
		return hasBadge3;
	}

	public void setHasBadge3(boolean hasBadge3) {
		this.hasBadge3 = hasBadge3;
	}

	public boolean isHasBadge4() {
		return hasBadge4;
	}

	public void setHasBadge4(boolean hasBadge4) {
		this.hasBadge4 = hasBadge4;
	}

	public boolean isHasBadge5() {
		return hasBadge5;
	}

	public void setHasBadge5(boolean hasBadge5) {
		this.hasBadge5 = hasBadge5;
	}

	public boolean isHasBadge6() {
		return hasBadge6;
	}

	public void setHasBadge6(boolean hasBadge6) {
		this.hasBadge6 = hasBadge6;
	}

	public Double getMidtermExam() {
		return midtermExam;
	}

	public void setMidtermExam(Double midtermExam) {
		this.midtermExam = midtermExam;
	}

	public Double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(Double finalExam) {
		this.finalExam = finalExam;
	}

	public Double getParticipation() {
		return participation;
	}

	public void setParticipation(Double participation) {
		this.participation = participation;
	}
	
	
	
}

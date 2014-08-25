package com.bosecker.tm.account;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;
import java.util.Calendar;


@SuppressWarnings("serial")
@Entity
@Table(name = "tm_student")
public class TmStudent implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(optional = false)
    @JoinColumn(name = "accountId")
    private Account account;
	
	@Column(name="hw1")
	private int hw1 = 0;
	
	@Column (name="hw2")
	private int hw2 = 0;
	
	@Column (name="hw3")
	private int hw3 = 0;
	
	@Column (name="hw4")
	private int hw4 = 0;
	
	@Column (name="hw5")
	private int hw5 = 0;
	
	@Column (name="midterm")
	private int midterm = 0;
	
	@Column (name="thefinal")
	private int thefinal = 0;
	
	@Column (name="participation")
	private int participation = 40;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(unique = true)
	private String characterName;
	
	@CreatedDate
	@Column
	private Date createdAt;
	
	@LastModifiedDate
	@Column
	private Date updatedAt;

	
	protected TmStudent() {

	}
	
	public TmStudent(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = new Date(Calendar.getInstance().getTimeInMillis());
		this.updatedAt = new Date(Calendar.getInstance().getTimeInMillis());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

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

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getHw1() {
		return hw1;
	}

	public void setHw1(Integer hw1) {
		this.hw1 = hw1;
	}

	public Integer getHw2() {
		return hw2;
	}

	public void setHw2(Integer hw2) {
		this.hw2 = hw2;
	}

	public Integer getHw3() {
		return hw3;
	}

	public void setHw3(Integer hw3) {
		this.hw3 = hw3;
	}

	public Integer getHw4() {
		return hw4;
	}

	public void setHw4(Integer hw4) {
		this.hw4 = hw4;
	}

	public Integer getHw5() {
		return hw5;
	}

	public void setHw5(Integer hw5) {
		this.hw5 = hw5;
	}

	public Integer getMidterm() {
		return midterm;
	}

	public void setMidterm(Integer midterm) {
		this.midterm = midterm;
	}

	public Integer getThefinal() {
		return thefinal;
	}

	public void setThefinal(Integer thefinal) {
		this.thefinal = thefinal;
	}

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}

}

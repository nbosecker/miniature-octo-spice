package com.bosecker.tm.account;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;
import java.util.Calendar;


@SuppressWarnings("serial")
@Entity
@Table(name = "tm_student")
@NamedQuery(name = TmStudent.FIND_ALL, query = "select tm from TmStudent tm")
public class TmStudent implements Comparable, java.io.Serializable {

	public static final String FIND_ALL = "TmStudent.findAll";

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(optional = false)
    @JoinColumn(name = "accountId")
    private Account account;
	
	@Column(name="hw1")
	private double hw1 = 0.0;
	
	@Column (name="hw2")
	private double hw2 = 0.0;
	
	@Column (name="hw3")
	private double hw3 = 0.0;
	
	@Column (name="hw4")
	private double hw4 = 0.0;
	
	@Column (name="hw5")
	private double hw5 = 0.0;
	
	@Column (name="midterm")
	private double midterm = 0.0;
	
	@Column (name="thefinal")
	private double thefinal = 0.0;
	
	@Column (name="participation")
	private double participation = 40.0;
	
	@Column (name="badge1")
	private boolean badge1 = false;
	
	@Column (name="badge2")
	private boolean badge2 = false;
	
	@Column (name="badge3")
	private boolean badge3= false;
	
	@Column (name="badge4")
	private boolean badge4 = false;
	
	@Column (name="badge5")
	private boolean badge5 = false;
	
	@Column (name="badge6")
	private boolean badge6 = false;
		
	@Column (name="firstName")
	private String firstName;
	
	@Column (name="lastName")
	private String lastName;
	
	@Column (name="finalGrade")
	private double finalGrade = 0.0;
	
	@Column(name="characterName", unique = true)
	private String characterName;
	
	@CreatedDate
	@Column
	private Date createdAt;
	
	@LastModifiedDate
	@Column
	private Date updatedAt;

	
	public TmStudent() {

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

	public double getHw1() {
		return hw1;
	}

	public void setHw1(double hw1) {
		this.hw1 = hw1;
	}

	public double getHw2() {
		return hw2;
	}

	public void setHw2(double hw2) {
		this.hw2 = hw2;
	}

	public double getHw3() {
		return hw3;
	}

	public void setHw3(double hw3) {
		this.hw3 = hw3;
	}

	public double getHw4() {
		return hw4;
	}

	public void setHw4(double hw4) {
		this.hw4 = hw4;
	}

	public double getHw5() {
		return hw5;
	}

	public void setHw5(double hw5) {
		this.hw5 = hw5;
	}

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getThefinal() {
		return thefinal;
	}

	public void setThefinal(double thefinal) {
		this.thefinal = thefinal;
	}

	public double getParticipation() {
		return participation;
	}

	public void setParticipation(double participation) {
		this.participation = participation;
	}

	public boolean isBadge1() {
		return badge1;
	}

	public void setBadge1(boolean badge1) {
		this.badge1 = badge1;
	}

	public boolean isBadge2() {
		return badge2;
	}

	public void setBadge2(boolean badge2) {
		this.badge2 = badge2;
	}

	public boolean isBadge3() {
		return badge3;
	}

	public void setBadge3(boolean badge3) {
		this.badge3 = badge3;
	}

	public boolean isBadge4() {
		return badge4;
	}

	public void setBadge4(boolean badge4) {
		this.badge4 = badge4;
	}

	public boolean isBadge5() {
		return badge5;
	}

	public void setBadge5(boolean badge5) {
		this.badge5 = badge5;
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

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
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

	public boolean isBadge6() {
		return badge6;
	}

	public void setBadge6(boolean badge6) {
		this.badge6 = badge6;
	}
	
	
	public boolean isHealth40() {
		return this.participation>35 && this.participation<=40;
	}
	public boolean isHealth35() {
		return this.participation>30 && this.participation<=35;
	}
	public boolean isHealth30() {
		return this.participation>25 && this.participation<=30;
	}
	public boolean isHealth25() {
		return this.participation>20 && this.participation<=25;
	}
	public boolean isHealth20() {
		return this.participation>15 && this.participation<=20;
	}
	public boolean isHealth15() {
		return this.participation>10 && this.participation<=15;
	}
	public boolean isHealth10() {
		return this.participation>5 && this.participation<=10;
	}
	public boolean isHealth5() {
		return this.participation>0 && this.participation<=5;
	}
	public boolean isHealth0() {
		return this.participation<=0;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof TmStudent) {
			TmStudent tmStudent = (TmStudent)o;
			return (int) (tmStudent.finalGrade - finalGrade);
		}
		
		return 0;
	}
}

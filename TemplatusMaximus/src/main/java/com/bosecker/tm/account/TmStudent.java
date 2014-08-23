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

}

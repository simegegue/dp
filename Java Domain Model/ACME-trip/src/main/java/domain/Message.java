package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Message extends DomainEntity{
	//Constructor
	public Message(){
		
	}
	//Attributes
	private String subject;
	private String body;
	private Date moment;
	private String priority;
	private String starred;
	private String trash;
	private String spam;
	
	
	@NotBlank
	@NotNull
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@NotBlank
	@NotNull
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@NotBlank
	@NotNull
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@NotBlank
	@NotNull
	public String getStarred() {
		return starred;
	}
	public void setStarred(String starred) {
		this.starred = starred;
	}
	@NotBlank
	@NotNull
	public String getTrash() {
		return trash;
	}
	public void setTrash(String trash) {
		this.trash = trash;
	}
	@NotBlank
	@NotNull
	public String getSpam() {
		return spam;
	}
	public void setSpam(String spam) {
		this.spam = spam;
	}
	//Relationships
	private User senderUser;
	private User recipientUser;
	private Manager senderManager;
	private Manager recipientManager;
	private Administrator senderAdministrator;
	private Administrator recipientAdministrator;
	private Folder folder;


	@Valid
	@ManyToOne(optional=true)
	public User getSenderUser() {
		return senderUser;
	}
	public void setSenderUser(User senderUser) {
		this.senderUser = senderUser;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public User getRecipientUser() {
		return recipientUser;
	}
	public void setRecipientUser(User recipientUser) {
		this.recipientUser = recipientUser;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Manager getSenderManager() {
		return senderManager;
	}
	public void setSenderManager(Manager senderManager) {
		this.senderManager = senderManager;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Manager getRecipientManager() {
		return recipientManager;
	}
	public void setRecipientManager(Manager recipientManager) {
		this.recipientManager = recipientManager;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Administrator getSenderAdministrator() {
		return senderAdministrator;
	}
	public void setSenderAdministrator(Administrator senderAdministrator) {
		this.senderAdministrator = senderAdministrator;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Administrator getRecipientAdministrator() {
		return recipientAdministrator;
	}
	public void setRecipientAdministrator(Administrator recipientAdministrator) {
		this.recipientAdministrator = recipientAdministrator;
	}
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
}

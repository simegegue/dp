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
public class Comment extends DomainEntity{
	//Constructor
	public Comment(){
		
	}
	//Atributes
	private String title;
	private String text;
	private Date moment;
	private Boolean inappropiate;
	
	@NotBlank
	@NotNull
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotBlank
	@NotNull
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Valid
	@Temporal(TemporalType.DATE)
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@NotNull
	public Boolean getInappropiate() {
		return inappropiate;
	}
	public void setInappropiate(Boolean inappropiate) {
		this.inappropiate = inappropiate;
	}
//Relationships
	private Manager manager;
	private Administrator administrator;
	private User user;
	private Trip trip;
	private Activity activity;
	
	
	@Valid
	@ManyToOne(optional=true)
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@NotNull
	@Valid
	@ManyToOne(optional=true)
	public Trip getTrip() {
		return trip;
	}
	
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	@NotNull
	@Valid
	@ManyToOne(optional=true)
	public Activity getActivity() {
		return activity;
	}
	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}

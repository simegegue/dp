package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Trip extends DomainEntity{
	//Constructor//
	public Trip(){
		
	}
	//Attributes//
	private String title;
	private Date date;
	private String description;
	private String photo;
	@NotBlank
	@NotNull
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@NotBlank
	@NotNull
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@URL
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//Relationships//
	
	private User user;
	private Collection<Comment>comments;
	private Collection<DailyPlan>dailyPlans;
	private Collection<Subscription>subscriptions;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="trip",cascade=CascadeType.ALL)
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="trip",cascade=CascadeType.ALL)
	public Collection<DailyPlan> getDailyPlans() {
		return dailyPlans;
	}
	public void setDailyPlans(Collection<DailyPlan> dailyPlans) {
		this.dailyPlans = dailyPlans;
	}
	
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="trip",cascade=CascadeType.ALL)
	public Collection<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(Collection<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	
}

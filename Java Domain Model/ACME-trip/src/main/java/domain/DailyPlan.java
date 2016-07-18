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
public class DailyPlan extends DomainEntity{
//Constructor//
	public DailyPlan(){
		
	}
//Attributes//
	private Date day;
	private String title;
	private String description;
	private String photo;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
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
	private Trip trip;
	private Collection<Slot>slots;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="dailyPlan",cascade=CascadeType.ALL)
	public Collection<Slot> getSlots() {
		return slots;
	}
	public void setSlots(Collection<Slot> slots) {
		this.slots = slots;
	}
}

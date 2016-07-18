package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class User extends Actor {
//----------------Constructor------------------------//
	public User(){
		
	}
//---------------Attributes--------------------------//
	
//---------------Relationships-----------------------//
	private Collection<Trip>trips;
	private Collection<Activity>activities;
	private Collection<Folder>folders;
	private Collection<Subscription>subscriptions;
	
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="user")
	public Collection<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="user")
	public Collection<Folder> getFolders() {
		return folders;
	}
	public void setFolders(Collection<Folder> folders) {
		this.folders = folders;
	}

	@Valid
	@ElementCollection
	@OneToMany(mappedBy="user")
	public Collection<Trip> getTrips() {
		return trips;
	}
	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}
	
	@Valid
	@ElementCollection
	@OneToMany(mappedBy="user")
	public Collection<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(Collection<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}

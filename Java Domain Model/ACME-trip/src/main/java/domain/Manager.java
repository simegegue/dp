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
public class Manager extends Actor{
	//----------------Constructor----------------//
	public Manager(){
		
	}
	//-----------------Attributes---------------//
	
	//-----------------Relationships------------//
	private Collection<Folder>folders;
	

	@Valid
	@ElementCollection
	@OneToMany(mappedBy="manager")
	public Collection<Folder> getFolders() {
		return folders;
	}
	public void setFolders(Collection<Folder> folders) {
		this.folders = folders;
	}
}

package pet.apipet.domain;

import java.util.UUID;

public class InfoCategoryLocationDTO {
	
	private UUID id_InfoCategoryLocation;
	private String name;
	private String description;
	private short schedule;
	private String phoneNumber;
	
	public InfoCategoryLocationDTO(final UUID id_InfoCategoryLocation,final String name, final String description, 
		final short schedule, final String phoneNumber) {
		setId_InfoCategoryLocation(id_InfoCategoryLocation);
		setName(name);
		setDescription(description);
		setSchedule(schedule);
		setPhoneNumber(phoneNumber);
	}
	
	public static final InfoCategoryLocationDTO create (final UUID id_InfoCategoryLocation,final String name, final String description, 
		final short schedule, final String phoneNumber) {
		return new InfoCategoryLocationDTO(id_InfoCategoryLocation,name,description,schedule,phoneNumber);
	}
	
	public final UUID getId_InfoCategoryLocation() {
		return id_InfoCategoryLocation;
	}
	public final void setId_InfoCategoryLocation(UUID id_InfoCategoryLocation) {
		this.id_InfoCategoryLocation = id_InfoCategoryLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public short getSchedule() {
		return schedule;
	}
	public void setSchedule(short schedule) {
		this.schedule = schedule;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

}

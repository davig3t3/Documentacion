package pet.apipet.domain.builder;
import java.util.UUID;

import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.InfoCategoryLocationDTO;

public class InfoCategoryLocationDTOBuilder {
	
	private UUID id_InfoCategoryLocation;
	private String name;
	private String description;
	private short schedule;
	private String phoneNumber;
	
	private InfoCategoryLocationDTOBuilder() {
		super();
	}
	
	public static final InfoCategoryLocationDTOBuilder getInfoCategoryLocationDTOBuilder(){
		return new InfoCategoryLocationDTOBuilder();
	}

	public final InfoCategoryLocationDTOBuilder setId_InfoCategoryLocation(UUID id_InfoCategoryLocation) {
		this.id_InfoCategoryLocation = id_InfoCategoryLocation;
		return this;
	}

	public final InfoCategoryLocationDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final InfoCategoryLocationDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final InfoCategoryLocationDTOBuilder setSchedule(short schedule) {
		this.schedule = schedule;
		return this;
	}

	public final InfoCategoryLocationDTOBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public final InfoCategoryLocationDTO build() {
		return InfoCategoryLocationDTO.create(id_InfoCategoryLocation, name, description, schedule, phoneNumber);
	}

}

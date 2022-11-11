package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.BasicCareDTO;

public class BasicCareDTOBuilder {
	
	private UUID id_care;
	private String name;
	private short Date;
	
	private BasicCareDTOBuilder() {
		super();
	}
	
	public static final BasicCareDTOBuilder getBasicCareDTOBuilder(){
		return new BasicCareDTOBuilder();
	}

	public final BasicCareDTOBuilder setId_care(UUID id_care) {
		this.id_care = id_care;
		return this;
	}

	public final BasicCareDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final BasicCareDTOBuilder setDate(short date) {
		Date = date;
		return this;
	}
	
	public final BasicCareDTO build() {
		return BasicCareDTO.create(id_care, name, Date);
	}
	
	
	
}

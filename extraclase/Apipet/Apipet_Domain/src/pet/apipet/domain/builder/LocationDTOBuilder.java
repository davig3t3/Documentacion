package pet.apipet.domain.builder;

import java.util.UUID;
import pet.apipet.domain.LocationDTO;
public class LocationDTOBuilder {
	
	private UUID id_location;
	private String coordinates;
	
	public LocationDTOBuilder() {
		super();
	}
	
	public static final LocationDTOBuilder getLocationDTOBuilder(){
		return new LocationDTOBuilder();
	}

	public final LocationDTOBuilder setId_location(UUID id_location) {
		this.id_location = id_location;
		return this;
	}

	public final LocationDTOBuilder setCoordinates(String coordinates) {
		this.coordinates = coordinates;
		return this;
	}
	
	public final LocationDTO build() {
		return LocationDTO.create(id_location, coordinates);
	}

	
}

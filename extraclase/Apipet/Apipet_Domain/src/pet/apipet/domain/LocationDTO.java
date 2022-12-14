package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.NumberHelper.ZERO;
import static pet.apipet.crosscutting.helper.StringHelper.EMPTY;
import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class LocationDTO {
	
	private UUID id_location;
	private String coordinates;
	
	public LocationDTO() {
		setId_location(id_location);
		setCoordinates(coordinates);
	}
	
	public LocationDTO(final UUID id_location,final String coordinates) {
		setId_location(id_location);
		setCoordinates(coordinates);
	}
	
	public static final LocationDTO create (final UUID id_location,final String coordinates) {
		return new LocationDTO(id_location,coordinates);
	}
	
	public final UUID getId_location() {
		return id_location;
	}
	public final String getIdAsString() {
		return getUUIDAsString(getId_location());
	}
	public final void setId_location(UUID id_location) {
		this.id_location = id_location;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}

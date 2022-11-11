package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static pet.apipet.crosscutting.helper.StringHelper.EMPTY;
import static pet.apipet.crosscutting.helper.StringHelper.applyTrim;
import java.util.UUID;



public class MapDTO {

	private UUID id;
	private String cityName;

	public MapDTO() {
		setId(getDefaultUUID(id));
		setCityName(EMPTY);
	}

	public MapDTO(final UUID id, final String cityName) {
		setId(id);
		setCityName(cityName);
	}

	public static final MapDTO create(final UUID id, final String cityName) {
		return new MapDTO(id, cityName);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public final String getCityName() {
		return cityName;
	}

	public void setCityName(final String cityName) {
		this.cityName = applyTrim(cityName);

	}

	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}

}

package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.MapDTO;

public class MapDTOBuilder {
	
	private UUID id;
	private String cityName;
	
	private MapDTOBuilder() {
		super();
	}
	
	public static final MapDTOBuilder getMapDTOBuilder() {
		return new MapDTOBuilder();
	}
	
	public final MapDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	public final MapDTOBuilder setCityName(final String cityName) {
		this.cityName = cityName;
		return this;
	}
	
	public final MapDTO build() {
		return MapDTO.create(id,cityName);
	}

}

package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.builder.MapDTOBuilder;

public interface MapDAO {
	
	void create(MapDTOBuilder map);

	List<MapDTOBuilder> find(MapDTOBuilder map);

	void update(MapDTOBuilder map);

	void delete(UUID id);


}

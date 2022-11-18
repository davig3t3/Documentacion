package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.MapDTO;
import pet.apipet.domain.builder.MapDTOBuilder;

public interface MapDAO {
	
	void create(MapDTO map);

	List<MapDTO> find(MapDTO map);

	void update(MapDTO map);

	void delete(UUID id);


}

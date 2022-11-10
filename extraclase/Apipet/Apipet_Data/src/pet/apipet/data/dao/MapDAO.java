package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.builder.MapDTO;

public interface MapDAO {
	
	void create(MapDTO map);

	List<MapDTO> find(MapDTO map);

	void update(MapDTO map);

	void delete(UUID id);


}

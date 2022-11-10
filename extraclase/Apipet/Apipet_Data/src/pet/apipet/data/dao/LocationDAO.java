package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.LocationDTO;

public interface LocationDAO {

	void create(LocationDTO location);

	List<LocationDTO> find(LocationDTO location);

	void update(LocationDTO location);

	void delete(UUID id);

}

package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.LocationDTO;

public interface LocationDAO {

	void create(LocationDTO basiccare);

	List<LocationDTO> find(LocationDTO basiccare);

	void update(LocationDTO basiccare);

	void delete(UUID id);

}

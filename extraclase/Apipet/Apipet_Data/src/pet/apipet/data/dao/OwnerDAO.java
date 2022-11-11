package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.OwnerDTO;


public interface OwnerDAO {
	
	void create(OwnerDTO owner);

	List<OwnerDTO> find(OwnerDTO owner);

	void update(OwnerDTO owner);

	void delete(UUID id);

}

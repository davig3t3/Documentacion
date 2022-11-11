package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.PetDTO;


public interface PetDAO {
	
	void create(PetDTO pet);

	List<PetDTO> find(PetDTO pet);

	void update(PetDTO pet);

	void delete(UUID id);

}

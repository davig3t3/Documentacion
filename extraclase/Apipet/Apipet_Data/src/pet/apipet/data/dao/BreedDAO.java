package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.BreedDTO;

public interface BreedDAO {
	
	void create( BreedDTO breed);
	
	List<BreedDTO> find(BreedDTO breed);
	
	void update(BreedDTO breed);
	
	void delete(UUID id);


}

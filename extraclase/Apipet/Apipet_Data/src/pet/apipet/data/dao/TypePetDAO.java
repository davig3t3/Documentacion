package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.TypePetDTO;

public interface TypePetDAO {
	
	void create( TypePetDTO typepet);
	
	List<TypePetDTO> find(TypePetDTO typepet);
	
	void update(TypePetDTO typepet);
	
	void delete(UUID id);

}

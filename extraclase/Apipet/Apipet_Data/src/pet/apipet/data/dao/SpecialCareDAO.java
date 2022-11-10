package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.SpecialCareDTO;

public interface SpecialCareDAO {
	
	void create(SpecialCareDTO specialcare);

	List<SpecialCareDTO> find(SpecialCareDTO specialcare);

	void update(SpecialCareDTO specialcare);

	void delete(UUID id);

}

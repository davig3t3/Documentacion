package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.BasicCareDTO;

public interface BasicCareDAO {
	
	void create( BasicCareDTO basiccare);
	
	List<BasicCareDTO> find(BasicCareDTO basiccare);
	
	void update(BasicCareDTO basiccare);
	
	void delete(UUID id);

}

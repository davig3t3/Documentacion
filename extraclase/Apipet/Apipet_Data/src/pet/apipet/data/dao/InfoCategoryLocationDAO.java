package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.InfoCategoryLocationDTO;

public interface InfoCategoryLocationDAO {

	void create(InfoCategoryLocationDTO infocategorylocation);

	List<InfoCategoryLocationDTO> find(InfoCategoryLocationDTO infocategorylocation);

	void update(InfoCategoryLocationDTO infocategorylocation);

	void delete(UUID id);

}

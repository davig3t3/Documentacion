package pet.apipet.data.dao;

import java.util.List;
import java.util.UUID;

import pet.apipet.domain.CategoryLocationDTO;

public interface CategoryLocationDAO {

	void create(CategoryLocationDTO categorylocation);

	List<CategoryLocationDTO> find(CategoryLocationDTO categorylocation);

	void update(CategoryLocationDTO categorylocation);

	void delete(UUID id);

}

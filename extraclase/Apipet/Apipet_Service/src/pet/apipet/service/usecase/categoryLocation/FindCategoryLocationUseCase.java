package pet.apipet.service.usecase.categoryLocation;

import java.util.List;

import pet.apipet.domain.CategoryLocationDTO;

public interface FindCategoryLocationUseCase {
	
	List<CategoryLocationDTO> execute(CategoryLocationDTO categoryLocation);

}

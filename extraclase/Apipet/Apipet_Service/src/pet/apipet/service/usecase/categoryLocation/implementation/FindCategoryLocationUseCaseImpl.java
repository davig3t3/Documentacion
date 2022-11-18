package pet.apipet.service.usecase.categoryLocation.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.CategoryLocationDTO;
import pet.apipet.service.usecase.categoryLocation.FindCategoryLocationUseCase;

public class FindCategoryLocationUseCaseImpl implements FindCategoryLocationUseCase {

	private final DAOFactory factory;

	public FindCategoryLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;

	}

	@Override
	public List<CategoryLocationDTO> execute(CategoryLocationDTO categoryLocation) {
		// TODO Auto-generated method stub
		return factory.getCategoryLocationDAO().find(categoryLocation);
	}

}

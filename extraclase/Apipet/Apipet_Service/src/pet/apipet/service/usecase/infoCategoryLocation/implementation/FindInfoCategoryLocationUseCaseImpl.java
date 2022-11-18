package pet.apipet.service.usecase.infoCategoryLocation.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.InfoCategoryLocationDTO;
import pet.apipet.service.usecase.infoCategoryLocation.FindInfoCategoryLocationUseCase;

public class FindInfoCategoryLocationUseCaseImpl implements FindInfoCategoryLocationUseCase {

	private final DAOFactory factory;

	public FindInfoCategoryLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public List<InfoCategoryLocationDTO> execute(InfoCategoryLocationDTO infoCategoryLocation) {
		// TODO Auto-generated method stub
		return factory.getInfoCategoryLocationDAO().find(infoCategoryLocation);
	}

}

package pet.apipet.service.usecase.basicCare.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;

public class FindBasicCareUseCaseImpl implements FindBasicCareUseCase{

	private final DAOFactory factory;
	
	public FindBasicCareUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<BasicCareDTO> execute(BasicCareDTO basicCare) {
		// TODO Auto-generated method stub
		return factory.getBasicCareDAO().find(basicCare);
	}

}

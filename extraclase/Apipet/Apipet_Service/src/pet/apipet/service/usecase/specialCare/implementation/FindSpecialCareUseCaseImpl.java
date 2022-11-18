package pet.apipet.service.usecase.specialCare.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.SpecialCareDTO;
import pet.apipet.service.usecase.specialCare.FindSpecialCareUseCase;

public class FindSpecialCareUseCaseImpl implements FindSpecialCareUseCase{


	private final DAOFactory factory;
	

	public FindSpecialCareUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}
	
	@Override
	public List<SpecialCareDTO> execute(SpecialCareDTO specialCare) {
		// TODO Auto-generated method stub
		return factory.getSpecialCareDAO().find(specialCare);
	}

}

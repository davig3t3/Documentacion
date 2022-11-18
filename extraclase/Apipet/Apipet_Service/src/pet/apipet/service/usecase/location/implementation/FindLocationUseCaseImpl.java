package pet.apipet.service.usecase.location.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.LocationDTO;
import pet.apipet.service.usecase.location.FindLocationUseCase;

public class FindLocationUseCaseImpl implements FindLocationUseCase{

	
private final DAOFactory factory;
	

	public FindLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}
	
	
	@Override
	public List<LocationDTO> execute(LocationDTO location) {
		// TODO Auto-generated method stub
		return factory.getLocationDAO().find(location);
	}

}

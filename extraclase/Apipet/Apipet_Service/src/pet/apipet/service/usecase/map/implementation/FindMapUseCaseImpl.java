package pet.apipet.service.usecase.map.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.MapDTO;
import pet.apipet.service.usecase.map.FindMapUseCase;

public class FindMapUseCaseImpl implements FindMapUseCase {

	private final DAOFactory factory;

	public FindMapUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public List<MapDTO> execute(MapDTO map) {
		// TODO Auto-generated method stub
		return factory.getMapDAO().find(map);
	}

}

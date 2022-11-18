package pet.apipet.service.usecase.breed.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BreedDTO;
import pet.apipet.service.usecase.breed.FindBreedUseCase;

public class FindBreedUseCaseImpl implements FindBreedUseCase{
	
private final DAOFactory factory;
	
	public FindBreedUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<BreedDTO> execute(BreedDTO breed) {
		// TODO Auto-generated method stub
		return factory.getBreedDAO().find(breed);
	}

}

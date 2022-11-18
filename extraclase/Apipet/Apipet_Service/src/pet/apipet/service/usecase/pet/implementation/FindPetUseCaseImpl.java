package pet.apipet.service.usecase.pet.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.PetDTO;
import pet.apipet.service.usecase.pet.FindPetUseCase;

public class FindPetUseCaseImpl implements FindPetUseCase{

	private final DAOFactory factory;
	
	public FindPetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<PetDTO> execute(PetDTO pet) {
		// TODO Auto-generated method stub
		return factory.getPetDAO().find(pet);
	}

}

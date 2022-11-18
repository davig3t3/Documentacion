package pet.apipet.service.usecase.typePet.implementation;

import java.util.List;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.TypePetDTO;
import pet.apipet.service.usecase.typePet.FindTypePetUseCase;

public class FindTypePetUseCaseImpl implements FindTypePetUseCase{


	private final DAOFactory factory;
	

	public FindTypePetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}
	
	@Override
	public List<TypePetDTO> execute(TypePetDTO typePet) {
		// TODO Auto-generated method stub
		return factory.getTypePetDAO().find(typePet);
	}

}

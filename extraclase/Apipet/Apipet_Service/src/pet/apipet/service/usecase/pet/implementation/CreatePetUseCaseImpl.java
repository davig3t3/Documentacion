package pet.apipet.service.usecase.pet.implementation;

import java.util.List;

import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.PetDTO;
import pet.apipet.service.usecase.pet.CreatePetUseCase;
import pet.apipet.service.usecase.pet.FindPetUseCase;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;

public final class CreatePetUseCaseImpl implements CreatePetUseCase{

	private final DAOFactory factory;
	private final FindPetUseCase findPetUseCase;
	
	
	public CreatePetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findPetUseCase = new FindPetUseCaseImpl(factory);
	}
	
	@Override
	public void execute(PetDTO pet) {
		// TODO Auto-generated method stub
		pet.setId(UUIDHelper.getNewUUID());
		pet.setNamePet(pet.getNamePet());
		pet.setBirthDate(pet.getBirthDate());
		factory.getPetDAO().create(pet);
	}
	
	private final void validateIfPetExist(PetDTO pet) {
		final List<PetDTO> results = findPetUseCase.execute(pet);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

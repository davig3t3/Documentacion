package pet.apipet.service.usecase.breed.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.BreedDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.breed.CreateBreedUseCase;
import pet.apipet.service.usecase.breed.FindBreedUseCase;

public class CreateBreedUseCaseImpl implements CreateBreedUseCase{

	private final DAOFactory factory;
	private final FindBreedUseCase findBreedUseCase;
	
	public CreateBreedUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findBreedUseCase = new FindBreedUseCaseImpl(factory);
	}
	
	
	@Override
	public void execute(BreedDTO breed) {
		// TODO Auto-generated method stub
		
		breed.setId_breed(UUIDHelper.getNewUUID());
		breed.setColors(breed.getColors());
		breed.setDescription(breed.getDescription());
		breed.setHeight(breed.getHeight());
		breed.setName(breed.getName());
		breed.setOrigin(breed.getOrigin());
		breed.setTemper(breed.getTemper());
		breed.setWeight(breed.getWeight());
		factory.getBreedDAO().create(breed);
	}
	
	private final void validateIfBreedExist(BreedDTO breed) {
		final List<BreedDTO> results = findBreedUseCase.execute(breed);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

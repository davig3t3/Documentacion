package pet.apipet.service.usecase.location.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.LocationDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.location.CreateLocationUseCase;
import pet.apipet.service.usecase.location.FindLocationUseCase;

public class CreateLocationUseCaseImpl implements CreateLocationUseCase{

	private final DAOFactory factory;
	private final FindLocationUseCase findLocationUseCase;
	
	public CreateLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findLocationUseCase = new FindLocationUseCaseImpl(factory);
	}
	
	@Override
	public void execute(LocationDTO location) {
	
		location.setId_location(UUIDHelper.getNewUUID());
		location.setCoordinates(location.getCoordinates());
		factory.getLocationDAO().create(location);
	}
	
	private final void validateIfLocationExist(LocationDTO location) {
		final List<LocationDTO> results = findLocationUseCase.execute(location);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

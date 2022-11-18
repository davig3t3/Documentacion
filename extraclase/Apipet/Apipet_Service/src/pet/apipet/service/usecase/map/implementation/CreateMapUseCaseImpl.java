package pet.apipet.service.usecase.map.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.MapDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.map.CreateMapUseCase;
import pet.apipet.service.usecase.map.FindMapUseCase;

public class CreateMapUseCaseImpl implements CreateMapUseCase{

	private final DAOFactory factory;
	private final FindMapUseCase findMapUseCase;
	
	public CreateMapUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findMapUseCase = new FindMapUseCaseImpl(factory);
	}
	
	@Override
	public void execute(MapDTO map) {
		// TODO Auto-generated method stub
		
		map.setId(UUIDHelper.getNewUUID());
		map.setCityName(map.getCityName());
		factory.getMapDAO().create(map);
	}
	
	private final void validateIfMapCareExist(MapDTO map) {
		final List<MapDTO> results = findMapUseCase.execute(map);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

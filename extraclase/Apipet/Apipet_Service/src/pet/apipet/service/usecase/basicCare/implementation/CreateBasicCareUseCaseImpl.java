package pet.apipet.service.usecase.basicCare.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.service.usecase.basicCare.CreateBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.pet.FindPetUseCase;
import pet.apipet.service.usecase.pet.implementation.FindPetUseCaseImpl;

public final class CreateBasicCareUseCaseImpl implements CreateBasicCareUseCase{

	private final DAOFactory factory;
	private final FindBasicCareUseCase findBasicCareUseCase;
	
	public CreateBasicCareUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findBasicCareUseCase = new FindBasicCareUseCaseImpl(factory);
	}
	
	@Override
	public void execute(BasicCareDTO basicCare) {
		// TODO Auto-generated method stub
		basicCare.setId_care(UUIDHelper.getNewUUID());
		basicCare.setName(basicCare.getName());
		basicCare.setDate(basicCare.getDate());
		factory.getBasicCareDAO().create(basicCare);
	}
	
	private final void validateIfBasicCareExist(BasicCareDTO basicCare) {
		final List<BasicCareDTO> results = findBasicCareUseCase.execute(basicCare);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

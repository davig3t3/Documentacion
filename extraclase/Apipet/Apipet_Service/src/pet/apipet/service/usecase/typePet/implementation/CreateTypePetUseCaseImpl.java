package pet.apipet.service.usecase.typePet.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.TypePetDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.typePet.CreateTypePetUseCase;
import pet.apipet.service.usecase.typePet.FindTypePetUseCase;

public class CreateTypePetUseCaseImpl implements CreateTypePetUseCase{

	private final DAOFactory factory;
	private final FindTypePetUseCase findTypePetUseCase;
	
	public CreateTypePetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findTypePetUseCase = new FindTypePetUseCaseImpl(factory);
	}
	
	@Override
	public void execute(TypePetDTO typePet) {
		// TODO Auto-generated method stub
		
		typePet.setId(UUIDHelper.getNewUUID());
		typePet.setNameTypePet(typePet.getNameTypePet());
		factory.getTypePetDAO().create(typePet);
		
	}
	
	private final void validateIfTypePetExist(TypePetDTO typePet) {
		final List<TypePetDTO> results = findTypePetUseCase.execute(typePet);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

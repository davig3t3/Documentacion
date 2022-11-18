package pet.apipet.service.usecase.specialCare.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.SpecialCareDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.specialCare.CreateSpecialCareUseCase;
import pet.apipet.service.usecase.specialCare.FindSpecialCareUseCase;

public class CreateSpecialCareUseCaseImpl implements CreateSpecialCareUseCase{

	private final DAOFactory factory;
	private final FindSpecialCareUseCase findSpecialCareUseCase;
	
	public CreateSpecialCareUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findSpecialCareUseCase = new FindSpecialCareUseCaseImpl(factory);
	}
	
	@Override
	public void execute(SpecialCareDTO specialCare) {
		// TODO Auto-generated method stub
		
		specialCare.setId(UUIDHelper.getNewUUID());
		specialCare.setDateUltimateCare(specialCare.getDateUltimateCare());
		specialCare.setDescriptionCare(specialCare.getNameDescriptionCare());
		specialCare.setNameCare(specialCare.getNameCare());
		factory.getSpecialCareDAO().create(specialCare);
	}
	
	private final void validateIfSpecialCareExist(SpecialCareDTO specialCare) {
		final List<SpecialCareDTO> results = findSpecialCareUseCase.execute(specialCare);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}

}

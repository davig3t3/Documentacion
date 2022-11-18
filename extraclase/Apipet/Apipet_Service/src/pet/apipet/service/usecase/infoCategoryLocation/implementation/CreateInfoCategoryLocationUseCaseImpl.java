package pet.apipet.service.usecase.infoCategoryLocation.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.InfoCategoryLocationDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.infoCategoryLocation.CreateInfoCategoryLocationUseCase;
import pet.apipet.service.usecase.infoCategoryLocation.FindInfoCategoryLocationUseCase;

public class CreateInfoCategoryLocationUseCaseImpl implements CreateInfoCategoryLocationUseCase{

	private final DAOFactory factory;
	private final FindInfoCategoryLocationUseCase findInfoCategoryLocationUseCase;
	
	public CreateInfoCategoryLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findInfoCategoryLocationUseCase = new FindInfoCategoryLocationUseCaseImpl(factory);
	}
	
	@Override
	public void execute(InfoCategoryLocationDTO infoCategoryLocation) {
		// TODO Auto-generated method stub
		
		infoCategoryLocation.setId_InfoCategoryLocation(UUIDHelper.getNewUUID());
		infoCategoryLocation.setDescription(infoCategoryLocation.getDescription());
		infoCategoryLocation.setName(infoCategoryLocation.getName());
		infoCategoryLocation.setPhoneNumber(infoCategoryLocation.getPhoneNumber());
		infoCategoryLocation.setSchedule(infoCategoryLocation.getSchedule());
		factory.getInfoCategoryLocationDAO().create(infoCategoryLocation);
	}
	
	private final void validateIfInfoCategoryLocationExist(InfoCategoryLocationDTO infoCategoryLocation) {
		final List<InfoCategoryLocationDTO> results = findInfoCategoryLocationUseCase.execute(infoCategoryLocation);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}
	
	

}

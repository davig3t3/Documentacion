package pet.apipet.service.usecase.categoryLocation.implementation;

import java.util.List;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.BasicCareDTO;
import pet.apipet.domain.CategoryLocationDTO;
import pet.apipet.service.usecase.basicCare.FindBasicCareUseCase;
import pet.apipet.service.usecase.basicCare.implementation.FindBasicCareUseCaseImpl;
import pet.apipet.service.usecase.categoryLocation.CreateCategoryLocationUseCase;
import pet.apipet.service.usecase.categoryLocation.FindCategoryLocationUseCase;

public class CreateCategoryLocationUseCaseImpl implements CreateCategoryLocationUseCase{

	
	private final DAOFactory factory;
	private final FindCategoryLocationUseCase findCategoryLocationUseCase;
	
	public CreateCategoryLocationUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findCategoryLocationUseCase = new FindCategoryLocationUseCaseImpl(factory);
	}
	
	@Override
	public void execute(CategoryLocationDTO categoryLocation) {
		// TODO Auto-generated method stub
		categoryLocation.setId_categoryLocation(UUIDHelper.getNewUUID());
		categoryLocation.setCategory(categoryLocation.getCategory());
		factory.getCategoryLocationDAO().create(categoryLocation);
	}
	
	private final void validateIfCategoryLocationExist(CategoryLocationDTO categoryLocation) {
		final List<CategoryLocationDTO> results = findCategoryLocationUseCase.execute(categoryLocation);
		if(!results.isEmpty()){
            throw ServiceCustomException.createUserException(Messages.CreatePetUseCaseImpl.BUSINESS_PET_EXIST);
        }
	}
	

}

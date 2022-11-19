package pet.apipet.service.command.implementation;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.data.enumeration.DAOFactoryType;
import pet.apipet.domain.CategoryLocationDTO;
import pet.apipet.service.command.CreateCategoryLocationCommand;
import pet.apipet.service.usecase.categoryLocation.CreateCategoryLocationUseCase;
import pet.apipet.service.usecase.categoryLocation.implementation.CreateCategoryLocationUseCaseImpl;
import pet.apipet.service.usecase.typePet.CreateTypePetUseCase;
import pet.apipet.service.usecase.typePet.implementation.CreateTypePetUseCaseImpl;

public class CreateCategoryLocationCommandImpl implements CreateCategoryLocationCommand {

	@Override
	public void execute(CategoryLocationDTO categoryLocation) {
		// TODO Auto-generated method stub
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CreateCategoryLocationUseCase useCase = new CreateCategoryLocationUseCaseImpl(factory);
		try {
			factory.initTransaction();
			// use case execution
			useCase.execute(categoryLocation);
			factory.confirmTransaction();
		} catch (ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (ApipetCustomException exception) {

			factory.cancelTransaction();

			throw ServiceCustomException.wrapException(null, exception);
		} catch (final Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBusinessException(null, exception);
		} finally {
			factory.closeConnection();
		}
	}

}

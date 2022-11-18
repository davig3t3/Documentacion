package pet.apipet.service.command.implementation;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.data.enumeration.DAOFactoryType;
import pet.apipet.domain.LocationDTO;
import pet.apipet.service.command.CreateLocationCommand;
import pet.apipet.service.usecase.location.CreateLocationUseCase;
import pet.apipet.service.usecase.location.implementation.CreateLocationUseCaseImpl;
import pet.apipet.service.usecase.owner.implementation.CreateOwnerUseCaseImpl;

public class CreateLocationCommandImpl implements CreateLocationCommand {

	@Override
	public final void execute(final LocationDTO location) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CreateLocationUseCase useCase = new CreateLocationUseCaseImpl(factory);
		try {
			factory.initTransaction();
			useCase.execute(location);
			factory.confirmTransaction();
		}  catch(ServiceCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		}
			catch (ApipetCustomException exception) {
				
			factory.cancelTransaction();
			
			throw ServiceCustomException.wrapException(null,exception);
		} catch (final Exception exception) {
			factory.cancelTransaction();
			throw ServiceCustomException.createBusinessException(null,exception);
		}finally {
			factory.closeConnection();
		}
		
		
	}

}

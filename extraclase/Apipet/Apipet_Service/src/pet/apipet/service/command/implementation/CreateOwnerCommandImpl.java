package pet.apipet.service.command.implementation;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.data.enumeration.DAOFactoryType;
import pet.apipet.domain.OwnerDTO;
import pet.apipet.service.command.CreateOwnerCommand;
import pet.apipet.service.usecase.owner.CreateOwnerUseCase;
import pet.apipet.service.usecase.owner.implementation.CreateOwnerUseCaseImpl;

public class CreateOwnerCommandImpl implements CreateOwnerCommand {
	
	@Override
	public final void execute(final OwnerDTO owner) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CreateOwnerUseCase useCase = new CreateOwnerUseCaseImpl(factory);
		try {
			factory.initTransaction();
			//use case execution
			useCase.execute(owner);
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

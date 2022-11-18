package pet.apipet.service.command.implementation;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.data.enumeration.DAOFactoryType;
import pet.apipet.domain.TypePetDTO;
import pet.apipet.service.command.CreateTypePetCommand;
import pet.apipet.service.usecase.owner.CreateOwnerUseCase;
import pet.apipet.service.usecase.owner.implementation.CreateOwnerUseCaseImpl;
import pet.apipet.service.usecase.typePet.CreateTypePetUseCase;
import pet.apipet.service.usecase.typePet.implementation.CreateTypePetUseCaseImpl;

public class CreateTypePetCommandImpl implements CreateTypePetCommand{

	@Override
	public final void execute(final TypePetDTO typePet) {
		// TODO Auto-generated method stub
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CreateTypePetUseCase useCase = new CreateTypePetUseCaseImpl(factory);
		try {
			factory.initTransaction();
			//use case execution
			useCase.execute(typePet);
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

package pet.apipet.service.command.implementation;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.data.enumeration.DAOFactoryType;
import pet.apipet.domain.MapDTO;
import pet.apipet.service.command.CreateMapCommand;
import pet.apipet.service.usecase.map.CreateMapUseCase;
import pet.apipet.service.usecase.map.implementation.CreateMapUseCaseImpl;
import pet.apipet.service.usecase.typePet.CreateTypePetUseCase;
import pet.apipet.service.usecase.typePet.implementation.CreateTypePetUseCaseImpl;

public class CreateMapCommandImpl implements CreateMapCommand {

	@Override
	public void execute(MapDTO map) {
		// TODO Auto-generated method stub
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CreateMapUseCase useCase = new CreateMapUseCaseImpl(factory);
		try {
			factory.initTransaction();
			// use case execution
			useCase.execute(map);
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

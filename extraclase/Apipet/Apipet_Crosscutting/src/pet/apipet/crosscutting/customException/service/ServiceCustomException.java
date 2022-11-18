package pet.apipet.crosscutting.customException.service;

import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.enumeration.LayerException;
import static pet.apipet.crosscutting.helper.StringHelper.EMPTY;

public class ServiceCustomException  extends ApipetCustomException{

	private ServiceCustomException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.SERVICE);
	}

	private static final long serialVersionUID = -7581138972968503560L;

	public static final ApipetCustomException create(final String userMessage, final String technicalMessage) {
		return new ServiceCustomException(new Exception(), technicalMessage, userMessage);
	}

	public static final ApipetCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ServiceCustomException(rootException, technicalMessage, userMessage);
	}

	public static final ApipetCustomException createTechnicalException(final String technicalMessage) {
		return new ServiceCustomException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final ApipetCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new ServiceCustomException(rootException, technicalMessage,EMPTY);
	}
	
	public static final ApipetCustomException createBusinessException(
			final String businessMessage, final Exception rootException) {
		return new ServiceCustomException(rootException, businessMessage,EMPTY);
	}
	
	public static final ApipetCustomException createUserException(final String userMessage) {
		return new ServiceCustomException(null, userMessage, userMessage);
	}
	
	public static final ApipetCustomException wrapException(final String message, final ApipetCustomException exception) {
		if(exception.isTechnicalException()) {
			//wrapper negocio
			return ServiceCustomException.createBusinessException(message, exception);
		}
			
		return exception;
	}
	
	//public static final OwnerCustomException createUserException(final String userMessage, final Exception rootException) {
		//return new ServiceCustomException(rootException, userMessage, userMessage);
	//}
	
	//public static ServiceCustomException create1(String userMessage, String technicalMessage) {
	//	return new ServiceCustomException(new Exception(), userMessage, technicalMessage);
	//}
	
}
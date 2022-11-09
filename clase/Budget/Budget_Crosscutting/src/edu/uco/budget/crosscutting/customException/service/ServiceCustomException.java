package edu.uco.budget.crosscutting.customException.service;

import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.crosscutting.customException.enumeration.LayerException;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

public class ServiceCustomException  extends BudgetCustomException{

	private ServiceCustomException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.SERVICE);
	}

	private static final long serialVersionUID = -7581138972968503560L;

	public static final BudgetCustomException create(final String userMessage, final String technicalMessage) {
		return new ServiceCustomException(new Exception(), technicalMessage, userMessage);
	}

	public static final BudgetCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ServiceCustomException(rootException, technicalMessage, userMessage);
	}

	public static final BudgetCustomException createTechnicalException(final String technicalMessage) {
		return new ServiceCustomException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new ServiceCustomException(rootException, technicalMessage,EMPTY);
	}
	
	public static final BudgetCustomException createBusinessException(
			final String businessMessage, final Exception rootException) {
		return new ServiceCustomException(rootException, businessMessage,EMPTY);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage) {
		return new ServiceCustomException(null, userMessage, userMessage);
	}
	
	public static final BudgetCustomException wrapException(final String message, final BudgetCustomException exception) {
		if(exception.isTechnicalException()) {
			//wrapper negocio
			return ServiceCustomException.createBusinessException(message, exception);
		}
			
		return exception;
	}
	
	//public static final BudgetCustomException createUserException(final String userMessage, final Exception rootException) {
		//return new ServiceCustomException(rootException, userMessage, userMessage);
	//}
	
	//public static ServiceCustomException create1(String userMessage, String technicalMessage) {
	//	return new ServiceCustomException(new Exception(), userMessage, technicalMessage);
	//}
	
}

package pet.apipet.crosscutting.customException.data;


import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.enumeration.LayerException;
import static pet.apipet.crosscutting.helper.StringHelper.EMPTY;

public class DataCustomException  extends ApipetCustomException{

	private DataCustomException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.DATA);
	}

	private static final long serialVersionUID = -7581138972968503560L;

	public static final ApipetCustomException create(final String userMessage, final String technicalMessage) {
		return new DataCustomException(new Exception(), technicalMessage, userMessage);
	}

	public static final ApipetCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(rootException, technicalMessage, userMessage);
	}

	public static final ApipetCustomException createTechnicalException(final String technicalMessage) {
		return new DataCustomException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final ApipetCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new DataCustomException(rootException, technicalMessage,EMPTY);
	}
	
	public static final ApipetCustomException createUserException(final String userMessage, final Exception rootException) {
		return new DataCustomException(rootException, userMessage, userMessage);
	}
}

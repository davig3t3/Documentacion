package pet.apipet.crosscutting.customException;


import static pet.apipet.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import pet.apipet.crosscutting.customException.enumeration.LayerException;
import static pet.apipet.crosscutting.helper.StringHelper.isEmpty;

public class ApipetCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String userMessage;
	private LayerException layer;

	protected ApipetCustomException(final Throwable rootException,final String technicalMessage,final String userMessage,
			final LayerException layer) {
		super(technicalMessage, getDefaultIfNull(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	public final String getUserMessage() {
		return userMessage;
	}

	private final void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public final LayerException getLayer() {
		return layer;
	}

	private final void setLayer(LayerException layer) {
		this.layer = getDefaultIfNull(layer, LayerException.APPLICATION);
	}
	
	public final boolean isTechnicalException() {
		return isEmpty(getUserMessage());
	}
}
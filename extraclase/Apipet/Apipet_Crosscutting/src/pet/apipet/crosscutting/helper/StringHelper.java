package pet.apipet.crosscutting.helper;
import static pet.apipet.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import java.util.Objects;

public class StringHelper {
	
	private StringHelper() {
		super();
	}
	
	public static final String EMPTY = " ";
	
	public static final String getDefaultString(String value, String defaultValue) {
		return getDefaultIfNull(value, defaultValue);
	}
	
	public static final String getDefaultString(String value) {
		return getDefaultIfNull(value,EMPTY);
	}
	
	public static final String applyTtim(String value) {
		return getDefaultString(value).trim();
	}
	
	public static final boolean isEmpty(String value) {
		return Objects.equals(value, EMPTY);
	}

}

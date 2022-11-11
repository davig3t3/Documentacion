package pet.apipet.domain;

import java.util.UUID;

public class BasicCareDTO {
	
	private UUID id_care;
	private String name;
	private short Date;
	
	public BasicCareDTO(final UUID id_care,final String name, final short Date) {
		setId_care(id_care);
		setName(name);
		setDate(Date);
	}
	
	public static final BasicCareDTO create (final UUID id_care, final String name, final short date) {
		return new BasicCareDTO(id_care,name,date);
	}

	public final UUID getId_care() {
		return id_care;
	}

	public final void setId_care(UUID id_care) {
		this.id_care = id_care;
	}

	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getDate() {
		return Date;
	}

	public void setDate(short date) {
		Date = date;
	}
	
	

}

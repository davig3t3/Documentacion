package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.StringHelper.applyTrim;
import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class TypePetDTO {
	
	private UUID id;
	private String nameTypePet;
	
	public TypePetDTO(final UUID id, final String nameTypePet) {
		setId(getDefaultUUID(id));
		setNameTypePet(nameTypePet);
	}

	public static final TypePetDTO create(final UUID id, final String nameTypePet) {
		return new TypePetDTO(id, nameTypePet);
	}

	public final UUID getId() {
		return id;
	}
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	

	public String getNameTypePet() {
		return nameTypePet;
	}

	public void setNameTypePet(final String nameTypePet) {
		this.nameTypePet = applyTrim(nameTypePet);
	}
}

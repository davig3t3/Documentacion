package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.NumberHelper.ZERO;
import static pet.apipet.crosscutting.helper.NumberHelper.isLessThan;
import static pet.apipet.crosscutting.helper.StringHelper.applyTrim;
import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class PetDTO {

	private UUID id;
	private String namePet;
	private short birthDate;

	public PetDTO(final UUID id, final String namePet, final short birthDate) {
		setId(getDefaultUUID(id));
		setNamePet(namePet);
		setBirthDate(birthDate);
	}

	public static final PetDTO create(final UUID id, final String namePet, final short birthDate) {
		return new PetDTO(id, namePet, birthDate);
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

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(final String namePet) {
		this.namePet = applyTrim(namePet);
	}

	public final short getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final short birthDate) {
		this.birthDate = isLessThan(birthDate, ZERO) ? ZERO : birthDate;
	}

}

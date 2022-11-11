package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.PetDTO;

public class PetDTOBuilder {

	private UUID id;
	private String namePet;
	private short birthDate;

	private PetDTOBuilder() {
		super();
	}

	public static final PetDTOBuilder getPetDTOBuilder() {
		return new PetDTOBuilder();
	}

	public final PetDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final PetDTOBuilder setNamePet(final String namePet) {
		this.namePet = namePet;
		return this;
	}

	public final PetDTOBuilder setBirthDate(final short birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public final PetDTO build() {
		return PetDTO.create(id, namePet, birthDate);
	}

}

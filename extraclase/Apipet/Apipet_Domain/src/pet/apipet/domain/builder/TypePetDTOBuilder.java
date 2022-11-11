package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.TypePetDTO;

public class TypePetDTOBuilder {
	
	private UUID id;
	private String nameTypePet;

	private TypePetDTOBuilder() {
		super();
	}

	public static final TypePetDTOBuilder getTypePetDTOBuilder() {
		return new TypePetDTOBuilder();
	}

	public final TypePetDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final TypePetDTOBuilder setNameTypePet(final String nameTypePet) {
		this.nameTypePet = nameTypePet;
		return this;
	}


	public final TypePetDTO build() {
		return TypePetDTO.create(id, nameTypePet);
	}

}

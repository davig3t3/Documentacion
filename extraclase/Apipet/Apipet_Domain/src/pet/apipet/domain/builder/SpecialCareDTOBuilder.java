package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.SpecialCareDTO;

public class SpecialCareDTOBuilder {
	
	private UUID id;
	private String nameCare;
	private String descriptionCare;
	private short dateUltimateCare;

	private SpecialCareDTOBuilder() {
		super();
	}

	public static final SpecialCareDTOBuilder getPetDTOBuilder() {
		return new SpecialCareDTOBuilder();
	}

	public final SpecialCareDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final SpecialCareDTOBuilder setNameCare(final String nameCare) {
		this.nameCare = nameCare;
		return this;
	}
	
	public final SpecialCareDTOBuilder setDescriptionCare(final String descriptionCare) {
		this.descriptionCare = descriptionCare;
		return this;
	}

	public final SpecialCareDTOBuilder setDateUltimateCare(final short dateUltimateCare) {
		this.dateUltimateCare = dateUltimateCare;
		return this;
	}

	public final SpecialCareDTO build() {
		return SpecialCareDTO.create(id,nameCare ,descriptionCare , dateUltimateCare);
	}

}

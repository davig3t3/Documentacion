package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.NumberHelper.ZERO;
import static pet.apipet.crosscutting.helper.NumberHelper.isLessThan;
import static pet.apipet.crosscutting.helper.StringHelper.applyTrim;
import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class SpecialCareDTO {
	
	private UUID id;
	private String nameCare;
	private String descriptionCare;
	private short dateUltimateCare;

	public SpecialCareDTO(final UUID id, final String nameCare, final String descriptionCare, final short dateUltimateCare) {
		setId(getDefaultUUID(id));
		setNameCare(nameCare);
		setDescriptionCare(descriptionCare);
		setDateUltimateCare(dateUltimateCare);
	}

	public static final SpecialCareDTO create(final UUID id, final String nameCare, final String descriptionCare, final short dateUltimateCare) {
		return new SpecialCareDTO(id, nameCare, descriptionCare, dateUltimateCare);
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

	public String getNameCare() {
		return nameCare;
	}

	public void setNameCare(final String nameCare) {
		this.nameCare = applyTrim(nameCare);
	}
	
	public String getNameDescriptionCare() {
		return descriptionCare;
	}

	public void setDescriptionCare(final String descriptionCare) {
		this.descriptionCare = applyTrim(descriptionCare);
	}

	public final short getDateUltimateCare() {
		return dateUltimateCare;
	}
	
	public void setDateUltimateCare(final short dateUltimateCare) {
		this.dateUltimateCare = isLessThan(dateUltimateCare, ZERO) ? ZERO : dateUltimateCare;
	}

}

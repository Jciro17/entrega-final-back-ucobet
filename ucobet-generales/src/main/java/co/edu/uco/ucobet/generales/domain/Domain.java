package co.edu.uco.ucobet.generales.domain;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class Domain {
	
	private UUID id;
	
	protected Domain(final UUID id) {
		setId(id);
	}

	public final UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}
	
	public void generateId() {
		this.id= UUIDHelper.generate();
	}

}

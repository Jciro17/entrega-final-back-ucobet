package co.edu.uco.ucobet.generales.domain.country;

import java.util.UUID;

import co.edu.uco.ucobet.generales.domain.Domain;

public class CountryDomain extends Domain {
	
	private String name;

	public CountryDomain(final UUID id,final String name) {
		super(id);
		setName(name);
	}
	
	public static final CountryDomain create(final UUID id,final String name) {
		return new CountryDomain(id,name);
	}

	public final String getName() {
		return name;
	}

	private final void setName(String name) {
		this.name = name;
	}

}

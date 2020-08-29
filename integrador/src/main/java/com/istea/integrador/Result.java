package com.istea.integrador;

import java.util.List;

public class Result {
	
	private ProvidedLocation providedLocation;
	
	private List<Locations> locations;

	public ProvidedLocation getProvidedLocation() {
		return providedLocation;
	}

	public void setProvidedLocation(ProvidedLocation providedLocation) {
		this.providedLocation = providedLocation;
	}

	public List<Locations> getLocations() {
		return locations;
	}

	public void setLocations(List<Locations> locations) {
		this.locations = locations;
	}
	
}

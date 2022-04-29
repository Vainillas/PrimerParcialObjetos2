package ar.unrn.tp3.modelo;

public class Region {
	private String nombreRegion;

	public Region(String nombreRegion) {
		validarConstructorRegion(nombreRegion);
		this.nombreRegion = nombreRegion;
	}

	private boolean validarConstructorRegion(String nombreRegion) {
		if (!nombreRegion.equals("China") && !nombreRegion.equals("US") && !nombreRegion.equals("Europa"))
			throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
		return true;
	}

	public String region() {
		return nombreRegion;
	}
}

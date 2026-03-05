package produit;

public enum Unite {
	GRAMME("g"), KILOGRAMME("kg"), LITRE("l"), CENTILTRE("cl"), MILLILITRE("ml"), PIECE("piece");

	private String unit;

	private Unite(String unite) {
		this.unit = unite;
	}

	@Override
	public String toString() {
		return unit;
	}
}
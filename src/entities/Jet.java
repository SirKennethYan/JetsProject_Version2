package entities;

public abstract class Jet {
	private String modelAircraft;
	private double speedAircraft;
	private int rangeAircraft;
	private long priceAircraft;

	public Jet() {
	}

	public Jet(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		this.modelAircraft = modelAircraft;
		this.speedAircraft = speedAircraft;
		this.rangeAircraft = rangeAircraft;
		this.priceAircraft = priceAircraft;
	}

	public String getModelAircraft() {
		return modelAircraft;
	}

	public void setModelAircraft(String modelAircraft) {
		this.modelAircraft = modelAircraft;
	}

	public double getSpeedAircraft() {
		return speedAircraft;
	}

	public void setSpeedAircraft(double speedAircraft) {
		this.speedAircraft = speedAircraft;
	}

	public int getRangeAircraft() {
		return rangeAircraft;
	}

	public void setRangeAircraft(int rangeAircraft) {
		this.rangeAircraft = rangeAircraft;
	}

	public long getPriceAircraft() {
		return priceAircraft;
	}

	public void setPriceAircraft(long priceAircraft) {
		this.priceAircraft = priceAircraft;
	}

	@Override
	public String toString() {
		return "Aircraft Model: " + modelAircraft +
				" Speed: " + speedAircraft + " MPH." +
				" Range: " + rangeAircraft + " Miles." +
				" Price: " + priceAircraft + " Dollars.";
	}
}

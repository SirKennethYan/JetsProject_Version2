package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Jet {
	private String modelAircraft;
	private double speedAircraft;
	private int rangeAircraft;
	private long priceAircraft;

	/**
	 * Default constructor for the Jet class.
	 */
	public Jet() {
	}

	/**
	 * Parameterized constructor for the Jet class.
	 *
	 * @param modelAircraft The model of the aircraft.
	 * @param speedAircraft The speed of the aircraft in MPH.
	 * @param rangeAircraft The range of the aircraft in miles.
	 * @param priceAircraft The price of the aircraft in dollars.
	 */
	public Jet(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		this.modelAircraft = modelAircraft;
		this.speedAircraft = speedAircraft;
		this.rangeAircraft = rangeAircraft;
		this.priceAircraft = priceAircraft;
	}

	/**
	 * Retrieves the model of the aircraft.
	 *
	 * @return The model of the aircraft.
	 */
	public String getModelAircraft() {
		return modelAircraft;
	}

	/**
	 * Sets the model of the aircraft.
	 *
	 * @param modelAircraft The model of the aircraft.
	 */
	public void setModelAircraft(String modelAircraft) {
		this.modelAircraft = modelAircraft;
	}

	/**
	 * Retrieves the speed of the aircraft in MPH.
	 *
	 * @return The speed of the aircraft in MPH.
	 */
	public double getSpeedAircraft() {
		return speedAircraft;
	}

	/**
	 * Sets the speed of the aircraft in MPH.
	 *
	 * @param speedAircraft The speed of the aircraft in MPH.
	 */
	public void setSpeedAircraft(double speedAircraft) {
		this.speedAircraft = speedAircraft;
	}

	/**
	 * Retrieves the range of the aircraft in miles.
	 *
	 * @return The range of the aircraft in miles.
	 */
	public int getRangeAircraft() {
		return rangeAircraft;
	}

	/**
	 * Sets the range of the aircraft in miles.
	 *
	 * @param rangeAircraft The range of the aircraft in miles.
	 */
	public void setRangeAircraft(int rangeAircraft) {
		this.rangeAircraft = rangeAircraft;
	}

	/**
	 * Retrieves the price of the aircraft in dollars.
	 *
	 * @return The price of the aircraft in dollars.
	 */
	public long getPriceAircraft() {
		return priceAircraft;
	}

	/**
	 * Sets the price of the aircraft in dollars.
	 *
	 * @param priceAircraft The price of the aircraft in dollars.
	 */
	public void setPriceAircraft(long priceAircraft) {
		this.priceAircraft = priceAircraft;
	}

	/**
	 * Returns a string representation of the Jet object.
	 *
	 * @return A string representation of the Jet object.
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("$#,###,###");

		String formattedPrice = decimalFormat.format(priceAircraft);

		return "Aircraft Model: " + modelAircraft +
				", Speed: " + speedAircraft + " MPH," +
				" Range: " + rangeAircraft + " Miles," +
				" Price: " + formattedPrice;
	}

}

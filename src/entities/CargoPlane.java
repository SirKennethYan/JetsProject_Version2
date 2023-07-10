package entities;

public class CargoPlane extends Jet implements CargoCarrier {

	/**
	 * Constructs a new instance of the CargoPlane class with default values for the
	 * attributes.
	 */
	public CargoPlane() {
		super();
	}

	/**
	 * Constructs a new instance of the CargoPlane class with the specified values
	 * for the attributes.
	 *
	 * @param modelAircraft The model of the cargo plane.
	 * @param speedAircraft The speed of the cargo plane in MPH.
	 * @param rangeAircraft The range of the cargo plane in miles.
	 * @param priceAircraft The price of the cargo plane.
	 */
	public CargoPlane(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	/**
	 * Loads cargo onto the cargo plane.
	 * This method is implemented from the CargoCarrier interface.
	 */
	@Override
	public void loadAllCargo() {
		System.out.println(getModelAircraft() + " is loading cargo!!!");
	}
}

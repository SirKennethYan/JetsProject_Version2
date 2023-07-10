package entities;

public class JetImpl extends Jet {

	/**
	 * Default constructor for the JetImpl class.
	 */
	public JetImpl() {

	}

	/**
	 * Constructor for the JetImpl class.
	 * 
	 * @param modelAircraft The model of the aircraft.
	 * @param speedAircraft The speed of the aircraft in MPH.
	 * @param rangeAircraft The range of the aircraft in miles.
	 * @param priceAircraft The price of the aircraft.
	 */
	public JetImpl(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

}

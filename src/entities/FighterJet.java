package entities;

public class FighterJet extends Jet implements CombatReady {

	/**
	 * Default constructor for the FighterJet class.
	 */
	public FighterJet() {

	}

	/**
	 * Constructor for the FighterJet class.
	 *
	 * @param modelAircraft The model of the fighter jet.
	 * @param speedAircraft The speed of the fighter jet in MPH.
	 * @param rangeAircraft The range of the fighter jet in miles.
	 * @param priceAircraft The price of the fighter jet.
	 */
	public FighterJet(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	/**
	 * Performs a dogfight action specific to the fighter jet.
	 * Overrides the dogFight method defined in the CombatReady interface.
	 */
	@Override
	public void dogFight() {
		if (getModelAircraft().equals("A-10 Warthog")) {
			System.out.println(getModelAircraft() + " GO BRRRRRRRRRRR!!!");
		} else {
			System.out.println(getModelAircraft() + " is engaging in Air-to-Air combat!!!");
		}
	}
}

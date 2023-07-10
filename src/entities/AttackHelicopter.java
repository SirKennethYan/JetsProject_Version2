package entities;

import java.util.ArrayList;
import java.util.List;

public class AttackHelicopter extends Jet implements CombatReady {
	public List<Jet> fleetOfJets = new ArrayList<>();

	/**
	 * Default constructor for the AttackHelicopter class.
	 */
	public AttackHelicopter() {

	}

	/**
	 * Constructor for the AttackHelicopter class.
	 *
	 * @param modelAircraft The model of the attack helicopter.
	 * @param speedAircraft The speed of the attack helicopter in MPH.
	 * @param rangeAircraft The range of the attack helicopter in miles.
	 * @param priceAircraft The price of the attack helicopter.
	 */
	public AttackHelicopter(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	/**
	 * Performs a dogfight action specific to the attack helicopter.
	 * Prints a message indicating that the attack helicopter is firing missiles.
	 */
	@Override
	public void dogFight() {
		System.out.println(this.getModelAircraft() + " is firing missles!!! ");
	}

}
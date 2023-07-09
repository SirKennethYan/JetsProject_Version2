package entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {

	}

	public FighterJet(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	@Override
	public void dogFight() {
		System.out.println(this.getModelAircraft() + " is engaging in Air-to-Air combat!!! ");
	}

	// public void fly() {

	// }

}

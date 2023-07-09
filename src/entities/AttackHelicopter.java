package entities;

import java.util.ArrayList;

public class AttackHelicopter extends Jet implements CombatReady {
	public ArrayList<Jet> fleetOfJets = new ArrayList<>();

	public AttackHelicopter() {

	}

	public AttackHelicopter(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	@Override
	public void dogFight() {
		System.out.println(this.getModelAircraft() + " is firing missles!!! ");
	}

	public void fly() {

	}

}
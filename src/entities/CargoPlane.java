package entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}

	public CargoPlane(String modelAircraft, double speedAircraft, int rangeAircraft, long priceAircraft) {
		super(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
	}

	@Override
	public void loadAllCargo() {
		System.out.println(getModelAircraft() + " is loading cargo!!!");

	}

	// public void fly() {

	// }

}

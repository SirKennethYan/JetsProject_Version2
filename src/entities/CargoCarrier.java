package entities;

public interface CargoCarrier {

	/**
	 * Loads all cargo onto the cargo carrier.
	 * The implementation of this method will handle loading cargo specific to the
	 * type of cargo carrier.
	 */
	public void loadAllCargo();

}

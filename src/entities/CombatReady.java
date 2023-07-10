package entities;

public interface CombatReady {

	/**
	 * Initiates a dogfight.
	 * 
	 * This method is implemented by classes that are combat-ready and capable of
	 * engaging in a dogfight.
	 * When called, it simulates a dogfight scenario specific to the implementing
	 * class.
	 */
	public void dogFight();

}

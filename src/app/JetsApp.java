package app;

import java.util.Scanner;
import entities.AirField;

public class JetsApp {
	private final Scanner userInput = new Scanner(System.in);
	private final AirField af = new AirField();

	/**
	 * The main method to start the JetsApp application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	/**
	 * Runs the JetsApp application by initializing the application and calling the
	 * printMenu method.
	 */
	private void run() {
		System.out.println("Welcome to the Jets App!");
		printMenu();
		userInput.close();
	}

	/**
	 * Displays the main menu to the user and handles the user's input.
	 * Continuously prompts for input until the user chooses to quit.
	 * After each user operation, prompts the user to press 'Enter' to return to the
	 * menu.
	 */
	private void printMenu() {
		while (true) {
			System.out.println("Make a selection from the list below:");
			System.out.println("1: List fleet");
			System.out.println("2: Fly all jets");
			System.out.println("3: View fastest jet");
			System.out.println("4: View jet with longest range");
			System.out.println("5: Load all Cargo Jets");
			System.out.println("6: Dogfight!");
			System.out.println("7: Add a jet to Fleet");
			System.out.println("8: Remove a jet from Fleet");
			System.out.println("0: Quit");

			String menuChoice = userInput.nextLine();
			System.out.println();

			switch (menuChoice) {
				case "1":
					viewListOfJets();
					break;
				case "2":
					fly();
					break;
				case "3":
					viewFastestJets();
					break;
				case "4":
					viewJetLongestRange();
					break;
				case "5":
					loadAllCargo();
					break;
				case "6":
					dogFight();
					break;
				case "7":
					addJetToFleet();
					break;
				case "8":
					removeJetFromFleet();
					break;
				case "0":
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("Invalid input. Enter a number between 1 and 9.");
					break;
			}

			System.out.println();
			System.out.println("Press 'Enter' to go back to the menu.");
			userInput.nextLine(); // Wait for user input to continue
			System.out.println();
		}
	}

	/**
	 * Displays the list of jets in the fleet.
	 */
	private void viewListOfJets() {
		af.showListOfJets();
	}

	/**
	 * Flies all the jets in the fleet.
	 */
	private void fly() {
		af.fly();
	}

	/**
	 * Displays the fastest jet in the fleet.
	 */
	private void viewFastestJets() {
		af.showFastestJet();
	}

	/**
	 * Displays the jet with the longest range in the fleet.
	 */
	private void viewJetLongestRange() {
		af.showLongestRange();
	}

	/**
	 * Loads cargo for all cargo jets in the fleet.
	 */
	private void loadAllCargo() {
		af.loadAllCargo();
	}

	/**
	 * Initiates a dogfight among the jets in the fleet.
	 */
	private void dogFight() {
		af.dogFight();
	}

	/**
	 * Prompts the user to add a new jet to the fleet and adds it to the AirField.
	 */
	private void addJetToFleet() {
		af.addJetToFleet(userInput);
	}

	/**
	 * Prompts the user to remove a jet from the fleet and removes it from the
	 * AirField.
	 */
	private void removeJetFromFleet() {
		af.removeJetFromFleet(userInput);
	}
}

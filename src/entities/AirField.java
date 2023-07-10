package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private final List<Jet> fleetOfJets = new ArrayList<>();

	/**
	 * Constructs an AirField object and initializes the fleet of jets by reading
	 * from a file.
	 *
	 * @param fileName The name of the file containing the jet data.
	 */
	public AirField() {
		String fileName = "jets.txt";
		readJets(fileName);
	}

	/**
	 * Retrieves the list of jets in the fleet.
	 *
	 * @return The list of jets in the fleet.
	 */
	public List<Jet> getFleetOfJets() {
		return fleetOfJets;
	}

	/**
	 * Reads jet data from a file and populates the fleet of jets.
	 *
	 * @param fileName The name of the file containing the jet data.
	 * @return The list of jets read from the file.
	 */
	public List<Jet> readJets(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] splitJetData = line.split(",");
				if (splitJetData.length != 5) {
					System.err.println("WARNING: Invalid data format for jet: " + line);
					continue; // Skip invalid jet data
				}
				String type = splitJetData[0];
				String modelAircraft = splitJetData[1];
				double speedAircraft;
				int rangeAircraft;
				long priceAircraft;
				try {
					speedAircraft = Double.parseDouble(splitJetData[2]);
					rangeAircraft = Integer.parseInt(splitJetData[3]);
					priceAircraft = Long.parseLong(splitJetData[4]);
				} catch (NumberFormatException e) {
					System.out.println("Invalid numeric data format for jet: " + line);
					continue; // Skip invalid jet data
				}

				Jet jet;
				switch (type.toLowerCase()) {
					case "fighterjet":
						jet = new FighterJet(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
						break;
					case "cargoplane":
						jet = new CargoPlane(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
						break;
					case "attackhelicopter":
						jet = new AttackHelicopter(modelAircraft, speedAircraft, rangeAircraft, priceAircraft);
						break;
					default:
						System.out.println("Invalid jet type: " + type);
						continue; // Skip invalid jet types
				}

				fleetOfJets.add(jet);
			}
		} catch (IOException e) {
			System.err.println("Error reading jets file: " + e.getMessage());
		}

		return fleetOfJets;
	}

	/**
	 * Displays the list of jets in the fleet.
	 */
	public void showListOfJets() {
		System.out.println("Total Jets: " + fleetOfJets.size());
		for (Jet jet : fleetOfJets) {
			System.out.println(jet);
		}
	}

	/**
	 * Flies all the jets in the fleet and displays their flight information.
	 */
	public void fly() {
		for (Jet jet : fleetOfJets) {
			double time = jet.getRangeAircraft() / jet.getSpeedAircraft();
			System.out.println(jet.getModelAircraft() + " is flying at a speed of " + jet.getSpeedAircraft()
					+ " MPH and will fly for " + Math.round(time) + " hours.");
		}
	}

	/**
	 * Displays the fastest jet in the fleet.
	 */
	public void showFastestJet() {
		Jet fastest = null;
		for (Jet jet : fleetOfJets) {
			if (fastest == null || jet.getSpeedAircraft() > fastest.getSpeedAircraft()) {
				fastest = jet;
			}
		}
		System.out.println("Fastest Jet is the " + fastest.getModelAircraft() + ". Speed: "
				+ fastest.getSpeedAircraft() + " MPH");
	}

	/**
	 * Displays the jet with the longest range in the fleet.
	 */
	public void showLongestRange() {
		Jet topRangeJet = fleetOfJets.get(0);
		for (Jet jet : fleetOfJets) {
			if (jet.getRangeAircraft() > topRangeJet.getRangeAircraft()) {
				topRangeJet = jet;
			}
		}
		System.out.println("Aircraft with Longest Range is the " + topRangeJet.getModelAircraft() + " with a range of "
				+ topRangeJet.getRangeAircraft() + " Miles.");
	}

	/**
	 * Loads cargo for all cargo planes in the fleet.
	 */
	public void loadAllCargo() {
		for (Jet jet : fleetOfJets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadAllCargo();
			}
		}
	}

	/**
	 * Initiates a dogfight among the fighter jets and attack helicopters in the
	 * fleet.
	 */
	public void dogFight() {
		for (Jet jet : fleetOfJets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).dogFight();
			} else if (jet instanceof AttackHelicopter) {
				((AttackHelicopter) jet).dogFight();
			}
		}
	}

	/**
	 * Prompts the user to add a new jet to the fleet and adds it to the AirField.
	 *
	 * @param userInput The Scanner object for reading user input.
	 */
	public void addJetToFleet(Scanner userInput) {
		System.out.print("Enter the Jet's model: ");
		String model = userInput.next();
		double speed = readDoubleInput(userInput, "Enter the Jet's speed: ");
		int range = readIntInput(userInput, "Enter the Jet's range: ");
		long price = readLongInput(userInput, "Enter the Jet's price: ");

		fleetOfJets.add(new JetImpl(model, speed, range, price));
		System.out.println("Jet added to fleet!");
	}

	/**
	 * Prompts the user to select a jet to remove from the fleet and removes it from
	 * the AirField.
	 *
	 * @param userInput The Scanner object for reading user input.
	 */
	public void removeJetFromFleet(Scanner userInput) {
		for (int i = 0; i < fleetOfJets.size(); i++) {
			System.out.println(i + 1 + ". " + fleetOfJets.get(i));
		}

		System.out.print("Select the number of the Jet to delete: ");
		try {
			int choice = userInput.nextInt();
			if (choice >= 1 && choice <= fleetOfJets.size()) {
				Jet removedJet = fleetOfJets.remove(choice - 1);
				System.out.println(removedJet.getModelAircraft() + " deleted!");
			} else {
				System.out.println("Not a valid choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}

	/**
	 * Reads a double value from the user input.
	 *
	 * @param scanner The Scanner object for reading user input.
	 * @param prompt  The prompt message for the user.
	 * @return The double value entered by the user.
	 */
	private double readDoubleInput(Scanner scanner, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid double value.");
				scanner.nextLine(); // Clear the input buffer
			}
		}
	}

	/**
	 * Reads an integer value from the user input.
	 *
	 * @param scanner The Scanner object for reading user input.
	 * @param prompt  The prompt message for the user.
	 * @return The integer value entered by the user.
	 */
	private int readIntInput(Scanner scanner, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer value.");
				scanner.nextLine(); // Clear the input buffer
			}
		}
	}

	/**
	 * Reads a long value from the user input.
	 *
	 * @param scanner The Scanner object for reading user input.
	 * @param prompt  The prompt message for the user.
	 * @return The long value entered by the user.
	 */
	private long readLongInput(Scanner scanner, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return scanner.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid long value.");
				scanner.nextLine(); // Clear the input buffer
			}
		}
	}
}
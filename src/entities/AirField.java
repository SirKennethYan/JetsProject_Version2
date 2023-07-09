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

	public AirField() {
		String fileName = "jets.txt";
		readJets(fileName);
	}

	public List<Jet> getFleetOfJets() {
		return fleetOfJets;
	}

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

	public void showListOfJets() {
		System.out.println("Total Jets: " + fleetOfJets.size());
		for (Jet jet : fleetOfJets) {
			System.out.println(jet);
		}
	}

	public void fly() {
		for (Jet jet : fleetOfJets) {
			double time = jet.getRangeAircraft() / jet.getSpeedAircraft();
			System.out.println("Aircraft Model: " + jet.getModelAircraft() + " Speed: " + jet.getSpeedAircraft()
					+ " MPH. Range: " + jet.getRangeAircraft() + " Miles.");
			System.out.println(jet.getModelAircraft() + " will fly for " + Math.round(time) + " hours.");
			System.out.println();
		}
	}

	public void showFastestJet() {
		Jet fastest = null;
		for (Jet jet : fleetOfJets) {
			if (fastest == null || jet.getSpeedAircraft() > fastest.getSpeedAircraft()) {
				fastest = jet;
			}
		}
		System.out.println("Fastest Jet: " + fastest);
	}

	public void showLongestRange() {
		Jet topRangeJet = fleetOfJets.get(0);
		for (Jet jet : fleetOfJets) {
			if (jet.getRangeAircraft() > topRangeJet.getRangeAircraft()) {
				topRangeJet = jet;
			}
		}
		System.out.println("Jet with Longest Range: " + topRangeJet);
	}

	public void loadAllCargo() {
		for (Jet jet : fleetOfJets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadAllCargo();
			}
		}
	}

	public void dogFight() {
		for (Jet jet : fleetOfJets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).dogFight();
			} else if (jet instanceof AttackHelicopter) {
				((AttackHelicopter) jet).dogFight();
			}
		}
	}

	public void addJetToFleet(Scanner userInput) {
		System.out.print("Enter the Jet's model: ");
		String model = userInput.next();
		double speed = readDoubleInput(userInput, "Enter the Jet's speed: ");
		int range = readIntInput(userInput, "Enter the Jet's range: ");
		long price = readLongInput(userInput, "Enter the Jet's price: ");

		fleetOfJets.add(new JetImpl(model, speed, range, price));
		System.out.println("Jet added to fleet!");
	}

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

package app;

import java.util.Scanner;
import entities.AirField;

public class JetsApp {
	private final Scanner userInput = new Scanner(System.in);
	private final AirField af = new AirField();

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	private void run() {
		System.out.println("Welcome to the Jets App! Choose a selection from the list below.");
		printMenu();
		userInput.close();
	}

	private void printMenu() {
		while (true) {
			System.out.println("MENU:");
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
		}
	}

	private void viewListOfJets() {
		af.showListOfJets();
	}

	private void fly() {
		af.fly();
	}

	private void viewFastestJets() {
		af.showFastestJet();
	}

	private void viewJetLongestRange() {
		af.showLongestRange();
	}

	private void loadAllCargo() {
		af.loadAllCargo();
	}

	private void dogFight() {
		af.dogFight();
	}

	private void addJetToFleet() {
		af.addJetToFleet(userInput);
	}

	private void removeJetFromFleet() {
		af.removeJetFromFleet(userInput);
	}

}

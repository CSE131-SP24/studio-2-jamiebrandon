package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("What is your start amount?");
		double startAmount = in.nextDouble();
		System.out.println("What is the win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many plays do you want to play?");
		int simulation = in.nextInt();
		
		int wins = 0;
		int losses = 0;
		

		for (int i = 0; i <= simulation; i++) {
			double amount = startAmount;
			int play = 0;
			while (amount > 0 && amount < winLimit) {
				if (Math.random() < winChance)
					amount++;

				else {
					amount--;
				}
				play++;
			}
			if (amount > startAmount) {
				System.out.println("Simulation " + i + ": " + play + " WIN");
				wins++;
				
			} else {
				System.out.println("Simulation " + i + ": " + play + " LOSE");
				losses++;
			}
		}
		System.out.println("Losses: " + losses + " Simulation: " + simulation);
		double Ruinrate = Math.round(((double)losses/simulation)*100.0)/100.0;
		double a = (1-winChance)/winChance;
		double numerator = (Math.pow(a, startAmount) - Math.pow(a, winLimit));
		double denominator = 1-Math.pow(a, winLimit);
		double expected =  numerator/denominator;
				
		System.out.println("Ruin Rate from Simulation: " + Ruinrate + " Expected Ruin Rate: " + expected);
	}

}
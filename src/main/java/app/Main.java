package app;

import java.util.Scanner;

import footballWorldCupScoreBoard.ScoreBoardFacade;
import footballWorldCupScoreBoard.ScoreBoardFacadeImpl;

public class Main {

	public static void main(String... args) {
		System.out.println("Football World Cup Score Board");
		ScoreBoardFacade scoreBoard = new ScoreBoardFacadeImpl();
		Scanner sc = new Scanner(System.in);
		int option = -1;

		do {
			System.out.println("----------------------");
			System.out.println("Choose one option:");
			System.out.println("1. Start Game");
			System.out.println("2. Finish Game");
			System.out.println("3. Update Score");
			System.out.println("4. Summary");
			System.out.println("5. Exit");
			System.out.println("----------------------");
			option = sc.nextInt();

			if (option == 4) {
				System.out.println("Summary: ");
				System.out.println(scoreBoard.getSummary());
			} else if (option < 4) {
				System.out.println("Introduce home team: ");
				String homeTeam = sc.next();
				System.out.println("Introduce away team: ");
				String awayTeam = sc.next();

				if (option == 1) {
					scoreBoard.startGame(homeTeam, awayTeam);
				} else if (option == 2) {
					scoreBoard.finishGame(scoreBoard.getGameByTeams(homeTeam, awayTeam));
				} else {
					System.out.println("Introduce home team score: ");
					int homeTeamScore = sc.nextInt();
					System.out.println("Introduce away team score: ");
					int awayTeamScore = sc.nextInt();

					scoreBoard.updateScore(scoreBoard.getGameByTeams(homeTeam, awayTeam), homeTeamScore, awayTeamScore);
				}

			}
			
		} while (option != 5);
		sc.close();
	}
}
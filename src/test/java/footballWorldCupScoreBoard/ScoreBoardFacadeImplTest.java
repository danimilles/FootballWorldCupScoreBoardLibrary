package footballWorldCupScoreBoard;

import java.util.logging.Logger;

import org.junit.Test;

public class ScoreBoardFacadeImplTest {

	private static final String END_LINE = "\n";
	private static final String TEAM1_TEST = "TEAM1";
	private static final String TEAM2_TEST = "TEAM2";
	private static final String TEAM3_TEST = "TEAM3";
	private static final String TEAM4_TEST = "TEAM4";
	private static final String TEAM5_TEST = "TEAM5";
	private static final String TEAM6_TEST = "TEAM6";
	private static final String TEAM7_TEST = "TEAM7";
	private static final String TEAM8_TEST = "TEAM8";
	private static final String TEAM9_TEST = "TEAM9";
	private static final String TEAM10_TEST = "TEAM10";
	private static final String TEAM11_TEST = "TEAM11";
	private static final String TEAM12_TEST = "TEAM12";
	

	@Test
	public void start_game_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Game game = scoreBoard.startGame(TEAM1_TEST, TEAM2_TEST);

		assert scoreBoard.getGameByTeams(TEAM1_TEST, TEAM2_TEST) != null;
		assert game != null;
		assert game.getHomeTeamScore() == 0;
		assert game.getAwayTeamScore() == 0;
	}

	@Test
	public void finish_game_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Game game = scoreBoard.startGame(TEAM1_TEST, TEAM2_TEST);
		scoreBoard.finishGame(game);

		assert scoreBoard.getGameByTeams(TEAM1_TEST, TEAM2_TEST) == null;
	}
	
	@Test
	public void cant_finish_another_board_game_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		ScoreBoardFacadeImpl secondScoreBoard = new ScoreBoardFacadeImpl();

		scoreBoard.startGame(TEAM1_TEST, TEAM2_TEST);
		Game secondGame = secondScoreBoard.startGame(TEAM3_TEST, TEAM4_TEST);
		scoreBoard.finishGame(secondGame);

		assert scoreBoard.getGameByTeams(TEAM1_TEST, TEAM2_TEST) != null;
		assert scoreBoard.getGameByTeams(TEAM3_TEST, TEAM4_TEST) == null;
		assert secondScoreBoard.getGameByTeams(TEAM3_TEST, TEAM4_TEST) != null;
	}


	@Test
	public void update_game_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Game game = scoreBoard.startGame(TEAM1_TEST, TEAM2_TEST);
		scoreBoard.updateScore(game, 2, 2);

		assert scoreBoard.getGameByTeams(TEAM1_TEST, TEAM2_TEST) != null;
		assert game.getHomeTeamScore() == 2;
		assert game.getAwayTeamScore() == 2;
	}

	@Test
	public void cant_update_another_board_game_test() {
		ScoreBoardFacadeImpl scoreBoardEmpty = new ScoreBoardFacadeImpl();
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();

		Game game = scoreBoard.startGame(TEAM1_TEST, TEAM2_TEST);
		scoreBoardEmpty.updateScore(game, 2, 2);

		assert scoreBoard.getGameByTeams(TEAM1_TEST, TEAM2_TEST) != null;
		assert scoreBoardEmpty.getGameByTeams(TEAM1_TEST, TEAM2_TEST) == null;
		assert game.getHomeTeamScore() == 0;
		assert game.getAwayTeamScore() == 0;
	}

	@Test
	public void summary_board_test() throws InterruptedException {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Game firstGame = scoreBoard.startGame(TEAM3_TEST, TEAM4_TEST);
		Game secondGame = scoreBoard.startGame(TEAM5_TEST, TEAM6_TEST);
		Game thirdGame = scoreBoard.startGame(TEAM7_TEST, TEAM8_TEST);
		Thread.sleep(1); //Delay to test compareTo by insertion instant
		Game fourthGame = scoreBoard.startGame(TEAM9_TEST, TEAM10_TEST);
		Game fifthGame = scoreBoard.startGame(TEAM11_TEST, TEAM12_TEST);

		scoreBoard.updateScore(firstGame, 2, 2);
		scoreBoard.updateScore(secondGame, 1, 1);
		scoreBoard.updateScore(thirdGame, 3, 2);
		scoreBoard.updateScore(fourthGame, 2, 3);
		scoreBoard.updateScore(fifthGame, 9, 1);

		String summary = scoreBoard.getSummary();
		String[] entrys = summary.split(END_LINE);
        Logger.getLogger(this.getClass().toString()).info(END_LINE + summary);

		assert entrys[0].equals(fifthGame.toString());
		assert entrys[1].equals(thirdGame.toString());
		assert entrys[2].equals(fourthGame.toString());
		assert entrys[3].equals(firstGame.toString());
		assert entrys[4].equals(secondGame.toString());
	}
}

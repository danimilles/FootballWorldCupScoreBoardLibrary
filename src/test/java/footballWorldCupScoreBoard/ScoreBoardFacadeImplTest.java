package footballWorldCupScoreBoard;

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
	public void start_match_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Match match = scoreBoard.startMatch(TEAM1_TEST, TEAM2_TEST);

		assert scoreBoard.getActiveMatchs().contains(match) == true;
		assert match != null;
		assert match.getHomeTeamScore() == 0;
		assert match.getAwayTeamScore() == 0;
	}

	@Test
	public void finish_match_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Match match = scoreBoard.startMatch(TEAM1_TEST, TEAM2_TEST);
		scoreBoard.finishGame(match);

		assert scoreBoard.getActiveMatchs().contains(match) == false;
	}
	
	@Test
	public void cant_finish_another_board_match_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		ScoreBoardFacadeImpl secondScoreBoard = new ScoreBoardFacadeImpl();

		Match match = scoreBoard.startMatch(TEAM1_TEST, TEAM2_TEST);
		Match secondMatch = secondScoreBoard.startMatch(TEAM3_TEST, TEAM4_TEST);
		scoreBoard.finishGame(secondMatch);

		assert scoreBoard.getActiveMatchs().contains(match) == true;
		assert scoreBoard.getActiveMatchs().contains(secondMatch) == false;
		assert secondScoreBoard.getActiveMatchs().contains(secondMatch) == true;
	}


	@Test
	public void update_match_test() {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Match match = scoreBoard.startMatch(TEAM1_TEST, TEAM2_TEST);
		scoreBoard.updateGame(match, 2, 2);

		assert scoreBoard.getActiveMatchs().contains(match) == true;
		assert match.getHomeTeamScore() == 2;
		assert match.getAwayTeamScore() == 2;
	}

	@Test
	public void cant_update_another_board_match_test() {
		ScoreBoardFacadeImpl scoreBoardEmpty = new ScoreBoardFacadeImpl();
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();

		Match match = scoreBoard.startMatch(TEAM1_TEST, TEAM2_TEST);
		scoreBoardEmpty.updateGame(match, 2, 2);

		assert scoreBoard.getActiveMatchs().contains(match) == true;
		assert scoreBoardEmpty.getActiveMatchs().contains(match) == false;
		assert match.getHomeTeamScore() == 0;
		assert match.getAwayTeamScore() == 0;
	}

	@Test
	public void summary_board_test() throws InterruptedException {
		ScoreBoardFacadeImpl scoreBoard = new ScoreBoardFacadeImpl();
		Match firstMatch = scoreBoard.startMatch(TEAM3_TEST, TEAM4_TEST);
		Match secondMatch = scoreBoard.startMatch(TEAM5_TEST, TEAM6_TEST);
		Match thirdMatch = scoreBoard.startMatch(TEAM7_TEST, TEAM8_TEST);
		Thread.sleep(1);
		Match fourthMatch = scoreBoard.startMatch(TEAM9_TEST, TEAM10_TEST);
		Match fifthMatch = scoreBoard.startMatch(TEAM11_TEST, TEAM12_TEST);

		scoreBoard.updateGame(firstMatch, 2, 2);
		scoreBoard.updateGame(secondMatch, 1, 1);
		scoreBoard.updateGame(thirdMatch, 3, 2);
		scoreBoard.updateGame(fourthMatch, 2, 3);
		scoreBoard.updateGame(fifthMatch, 9, 1);

		String summary = scoreBoard.getSummary();
		String[] entrys = summary.split(END_LINE);
		
		assert entrys[0].equals(fifthMatch.toString());
		assert entrys[1].equals(thirdMatch.toString());
		assert entrys[2].equals(fourthMatch.toString());
		assert entrys[3].equals(firstMatch.toString());
		assert entrys[4].equals(secondMatch.toString());
	}
}

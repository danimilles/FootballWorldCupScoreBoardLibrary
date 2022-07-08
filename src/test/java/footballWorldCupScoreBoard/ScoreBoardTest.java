package footballWorldCupScoreBoard; 
 
import org.junit.Test; 
 
public class ScoreBoardTest { 
 
	private static final String TEAM1_TEST = "TEAM1";
	private static final String TEAM2_TEST = "TEAM2";

	@Test
	public void start_match_test () { 
		ScoreBoard scoreBoard = new ScoreBoard(); 
		Match match = scoreBoard.startMatch(TEAM1_TEST , TEAM2_TEST); 
		 
		assert scoreBoard.getActiveMatchs().contains(match) == true; 
		assert match != null; 
		assert match.getHomeTeamScore() == 0; 
		assert match.getAwayTeamScore() == 0; 
	} 

	@Test
	public void finish_match_test () { 
		ScoreBoard scoreBoard = new ScoreBoard(); 
		Match match = scoreBoard.startMatch(TEAM1_TEST , TEAM2_TEST); 
		scoreBoard.finishGame(match);
		
		assert scoreBoard.getActiveMatchs().contains(match) == true; 
	} 
} 

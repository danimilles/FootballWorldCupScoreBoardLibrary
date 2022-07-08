package footballWorldCupScoreBoard; 
 
import org.junit.Test; 
 
public class ScoreBoardTest { 
 
	@Test
	public void start_match_test () { 
		ScoreBoard scoreBoard = new ScoreBoard(); 
		Match match = scoreBoard.startMatch("TEAM1" , "TEAM2"); 
		 
		assert match != null; 
		assert match.getHomeTeamScore() == 0; 
		assert match.getAwayTeamScore() == 0; 
	} 
} 

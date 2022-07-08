package footballWorldCupScoreBoard; 
 
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase; 
 
public class ScoreBoard extends TestCase { 

	private List<Match> activeMatchs;

	public ScoreBoard() {
		activeMatchs = new ArrayList<>();
	}
	
	public Match startMatch(String homeTeam, String awayTeam) {
		Match newMatch = new Match(homeTeam, awayTeam);
		activeMatchs.add(newMatch);
		return newMatch;
	}
	
	
	
} 

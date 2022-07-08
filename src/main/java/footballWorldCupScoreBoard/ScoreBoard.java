package footballWorldCupScoreBoard; 
 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase; 
 
public class ScoreBoard extends TestCase { 

	private Set<Match> activeMatchs;

	public ScoreBoard() {
		activeMatchs = new HashSet<>();
	}
	
	public Match startMatch(String homeTeam, String awayTeam) {
		Match newMatch = new Match(homeTeam, awayTeam);
		activeMatchs.add(newMatch);
		return newMatch;
	}
	
	public Set<Match> getActiveMatchs() {
		return activeMatchs;
	}

	public void finishGame(Match match) {
		activeMatchs.remove(match);
	}

	public void updateGame(Match match, int homeTeamScore, int awayTeamScore) {
		match.updateScore(homeTeamScore, awayTeamScore);
	}
	
	
} 

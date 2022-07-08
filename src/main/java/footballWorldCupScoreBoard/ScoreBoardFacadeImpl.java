package footballWorldCupScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreBoardFacadeImpl implements ScoreBoardFacade {

	private static final String END_LINE = "\n";
	private Set<Match> activeMatchs;

	public ScoreBoardFacadeImpl() {
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
		if (activeMatchs.contains(match)) {
			match.updateScore(homeTeamScore, awayTeamScore);
		}
	}

	public String getSummary() {
		StringBuilder result = new StringBuilder();
		List<Match> sortedMatchs = new ArrayList<>(activeMatchs);
		Collections.sort(sortedMatchs, Collections.reverseOrder());

		for (Match match : sortedMatchs) {
			result.append(match).append(END_LINE);
		}

		return result.toString();
	}

}

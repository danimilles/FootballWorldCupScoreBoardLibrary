package footballWorldCupScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreBoardFacadeImpl implements ScoreBoardFacade {

	private static final String END_LINE = "\n";
	private final Set<Game> activeMatchs;

	public ScoreBoardFacadeImpl() {
		activeMatchs = new HashSet<>();
	}

	public Game startGame(String homeTeam, String awayTeam) {
		Game newMatch = new Game(homeTeam, awayTeam);
		activeMatchs.add(newMatch);
		return newMatch;
	}

	public void finishGame(Game game) {
		activeMatchs.remove(game);
	}

	public void updateScore(Game game, int homeTeamScore, int awayTeamScore) {
		if (activeMatchs.contains(game)) {
			game.updateScore(homeTeamScore, awayTeamScore);
		}
	}

	public String getSummary() {
		StringBuilder result = new StringBuilder();
		List<Game> sortedMatchs = new ArrayList<>(activeMatchs);
		Collections.sort(sortedMatchs, Collections.reverseOrder());

		for (Game game : sortedMatchs) {
			result.append(game).append(END_LINE);
		}
		
		return result.toString();
	}

	public Game getGameByTeams(String homeTeam, String awayTeam) {
		for (Game game : activeMatchs) {
			if (homeTeam.equals(game.getHomeTeam()) && awayTeam.equals(game.getAwayTeam())) {
				return game;
			}
		}
		return null;
	}

}

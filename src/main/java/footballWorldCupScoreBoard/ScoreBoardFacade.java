package footballWorldCupScoreBoard;

public interface ScoreBoardFacade {

	public Match startMatch(String homeTeam, String awayTeam);

	public void finishGame(Match match);

	public void updateGame(Match match, int homeTeamScore, int awayTeamScore);

	public String getSummary();

}

package footballWorldCupScoreBoard;

public interface ScoreBoardFacade {

	public void startGame(String homeTeam, String awayTeam);

	public void finishGame(Game game);

	public void updateScore(Game game, int homeTeamScore, int awayTeamScore);

	public String getSummary();

	public Game getGameByTeams(String homeTeam, String awayTeam);
}
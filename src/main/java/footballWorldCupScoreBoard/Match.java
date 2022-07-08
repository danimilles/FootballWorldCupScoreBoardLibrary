package footballWorldCupScoreBoard;

public class Match { 
 
	private final String homeTeam;
	private final String awayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	
	public Match(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = 0;
		this.awayTeamScore = 0;
	}
	
	public String getHomeTeam() {
		return homeTeam;
	}
	
	public String getAwayTeam() {
		return awayTeam;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	
	void updateScore(int homeTeamScore, int awayTeamScore) {
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
	}
} 

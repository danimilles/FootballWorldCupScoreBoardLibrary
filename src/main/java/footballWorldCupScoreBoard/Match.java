package footballWorldCupScoreBoard;

import java.time.Instant;

public class Match implements Comparable<Match> {

	private final String homeTeam;
	private final String awayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	private final Instant creationTime;

	public Match(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = 0;
		this.awayTeamScore = 0;
		this.creationTime = Instant.now();
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

	@Override
	public String toString() {
		return homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
	}

	@Override
	public int compareTo(Match other) {
		int thisTotal = this.awayTeamScore + this.homeTeamScore;
		int otherTotal = other.awayTeamScore + other.homeTeamScore;
		int order = Integer.compare(thisTotal, otherTotal);

		return order == 0 ? other.creationTime.compareTo(this.creationTime) : order;
	}
}

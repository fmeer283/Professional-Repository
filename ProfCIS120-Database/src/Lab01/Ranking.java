package Lab01;

public class Ranking {
	protected int userId;
	protected int movieId;
	protected int movieRating;
	protected int timeStamp;
	
	public Ranking(int userId, int movieId, int movieRating, int timeStamp) {
		
	}
	public Ranking(String line) {
		 String[] tokens = line.split(" ");
		
		 int newInt0 = Integer.parseInt(tokens[0]);
		 int newInt1 = Integer.parseInt(tokens[1]);
		 int newInt2 = Integer.parseInt(tokens[2]);
		 int newInt3 = Integer.parseInt(tokens[3]);

		 this.setUserId(newInt0);
		 this.setMovieId(newInt1);
		 this.setMovieRating(newInt2);
		 this.setTimeStamp(newInt3);
	}
	public int getUserId() {
		return userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String toString() {
		return "\n" + "User Id = " + userId + "\nMovie Id = " + movieId + "\nMovie Rating = "
				+ movieRating + "\nTimeStamp = " + timeStamp + "\n"
				+ "*********************";
	}
	
}

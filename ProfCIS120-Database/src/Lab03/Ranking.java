package Lab03;

public class Ranking {
	protected String userId;
	protected String movieId;
	protected String movieRating;
	protected String timeStamp;
	
	public Ranking(String userId, String movieId, String movieRating, String timeStamp) {
		
	}
	public Ranking(String line) {
		 String[] tokens = line.split("\\s");

		 this.setUserId(tokens[0]);
		 this.setMovieId(tokens[1]);
		 this.setMovieRating(tokens[2]);
		 this.setTimeStamp(tokens[3]);
	}
	public String getUserId() {
		return userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public String getMovieRating() {
		return movieRating;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String toString() {
		return "\nUser Id = " + userId + 
				"\nMovie Id = " + movieId + 
				"\nMovie Rating = " + movieRating + 
				"\nTimeStamp = " + timeStamp + 
				"\n*********************";
	}
	
}

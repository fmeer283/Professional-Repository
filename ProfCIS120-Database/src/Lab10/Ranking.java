package Lab10;

public class Ranking implements Comparable<Ranking>{
	protected int userId;
	protected int movieId;
	protected int movieRating;
	protected int timeStamp;
	
	public Ranking() {}
	public Ranking(int userId, int movieId, int movieRating, int timeStamp) {
		
	}
	public Ranking(String line) {
		 String[] tokens = line.split("\\s");

		 this.setUserId(Integer.parseInt(tokens[0]));
		 this.setMovieId(Integer.parseInt(tokens[1]));
		 this.setMovieRating(Integer.parseInt(tokens[2]));
		 this.setTimeStamp(Integer.parseInt(tokens[3]));
	}
	//Add methodscompareToandequals.  
	//These should behave as standard, using the ranking’s timeStamp field to compare the ranking objects.
	@Override
	public int compareTo(Ranking o) {
		
		if (this.getTimeStamp() > o.getTimeStamp()) {
			return 1;
		}
		else if (this.getTimeStamp() < o.getTimeStamp()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public boolean equals(Ranking o) {
		
		if (this.compareTo(o) == 0) {
			return true;
		}
		else {
			return false;
		}
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

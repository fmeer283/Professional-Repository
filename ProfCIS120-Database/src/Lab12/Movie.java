package Lab12;

public class Movie {
	
	protected int movieId;
	protected String movieName;
	protected String releaseDate;
	protected String videoReleaseDate;
	protected String url;
	protected String[] tokens;
	protected Boolean[] boolMovieType = new Boolean[19];
	protected String[] stringMovieType = new String[]
		{ "unknown", "action", "adventure", "animation", "childrens",
			"comedy", "crime", "documentary", "drama", "fantasy",
            "film-Noir", "horror", "musical", "mystery", "romance",
            "sci-Fi", "thriller", "war", "western" };
	protected String[] isThisMovieType = new String[19];

	public Movie() {}
	public Movie(String line) 
		{
		String[] newArray = line.split("\\|");
		this.setTokens(newArray.clone());
	    
		this.setMovieId(Integer.parseInt(tokens[0]));
		this.setMovieName(tokens[1]);
		this.setReleaseDate(tokens[2]);
		this.setVideoReleaseDate(tokens[3]);
		this.setUrl(tokens[4]);
		
	    for (int i = 5; i < tokens.length; i++) {
			if (tokens[i].equals("1")) {
				boolMovieType[i-5] = true;
			} else
			{
				boolMovieType[i-5] = false;
			}
		}
		
		for (int j = 0; j < boolMovieType.length - 1; j++) {
			if (this.boolMovieType[j]) {
				isThisMovieType[j] = stringMovieType[j];
			}
		}
	}
	public Movie(int movieID, String movieName, String releaseDate, 
	String videoReleaseDate, String url, Boolean[] boolMovieType) 
	{	
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}
	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String[] getTokens() {
		return tokens.clone();
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	public Boolean[] getBoolMovieType() {
		return boolMovieType.clone();
	}
	public void setBoolMovieType(Boolean[] boolMovieType) {
		this.boolMovieType = boolMovieType;
	}
	public String[] getStringMovieType() {
		return stringMovieType.clone();
	}
	public void setStringMovieType(String[] stringMovieType) {
		this.stringMovieType = stringMovieType;
	}
	public String[] getIsThisMovieType() {
		return isThisMovieType;
	}
	public void setIsThisMovieType(String[] isThisMovieType) {
		this.isThisMovieType = isThisMovieType;
	}
	public String toString() {
		String movieInfo = ("\nMovie: \n"
		+ "Id: " + this.getMovieId() + "\n"
		+ "Name: " + this.getMovieName() + "\n"
		+ "Released: " + this.getReleaseDate() + "\n"
		+ "Video Released: " + this.getVideoReleaseDate() + "\n");
		String buildString = ""; 
		for (int j = 0; j < boolMovieType.length - 1; j++) {
			if (this.boolMovieType[j]) {
				buildString += "Type: "  + stringMovieType[j] + "\n";	
			}
		}
		String stars = "******************\n";
		String stringToPrint = (movieInfo + buildString + stars);
		return stringToPrint;
	}
}


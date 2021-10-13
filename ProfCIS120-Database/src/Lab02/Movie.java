package Lab02;

public class Movie {
	
	protected int movieID;
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

	public Movie(String line) 
		{
		String[] newArray = line.split("\\|");
		this.setTokens(newArray.clone());

	    System.out.println("*****************");
	    
		this.setMovieID(Integer.parseInt(tokens[0]));
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
	}
	public Movie(int movieID, String movieName, String releaseDate, 
	String videoReleaseDate, String url, Boolean[] boolMovieType) 
	{	
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
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
	public String toString() {
		String movieInfo = ("Movie: \n"
		+ "ID: " + this.getMovieID() + "\n"
		+ "Name: " + this.getMovieName() + "\n"
		+ "Released: " + this.getReleaseDate() + "\n"
		+ "Video Released: " + this.getVideoReleaseDate() + "\n");
		String tempString = ""; 
		for (int j = 0; j < boolMovieType.length - 1; j++) {
			if (this.boolMovieType[j]) {
				tempString += "Type: "  + stringMovieType[j] + "\n";	
			}
		}
		String newString = (movieInfo + tempString);
		return newString;
	}
}


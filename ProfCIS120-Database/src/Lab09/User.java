package Lab09;

public class User {
	// Stores data from a single movie rating user.
	// Relevant file is "u.user" (line 130 of README)
	// Should store the data in appropriate types and have getters/setters for each field
	// Zip codes need to be strings
	// Two constructors and a toString method
	private int id;
	private String age;
	private String gender;
	private String occupation;
	private String zipCode;
	protected String[] tokens;
	
	public User() {}
	
	public User(String line) {
		String[] newArray = line.split("\\|");
		this.setTokens(newArray.clone());
	    
		this.setId(Integer.parseInt(tokens[0]));
		this.setAge(tokens[1]);
		this.setGender(tokens[2]);
		this.setOccupation(tokens[3]);
		this.setZipCode(tokens[4]);
	}
	public User(int id, String age, String gender, String occupation, String zipCode) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String[] getTokens() {
		return tokens;
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	public String toString() {
		return "\nId = " + id + 
				"\nAge = " + age + 
				"\nGender = " + gender + 
				"\nOccupation = " + occupation +
				"\nZip Code = " + zipCode +
				"\n*********************";
	}
}
/*
 * u.user -- Demographic information about the users; this is a tab separated
 * list of user id | age | gender | occupation | zip code The user ids are the
 * ones used in the u.data data set.
 */

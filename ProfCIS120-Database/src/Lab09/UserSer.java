package Lab09;

import Dale_Imports.*;

import java.io.*;
import java.text.*;

public class UserSer implements Serializable{
	private static final long serialVersionUID = 1L;
		// See User class for additional information...
		private int id;
		private String age;
		private String gender;
		private String occupation;
		private String zipCode;
		protected String[] tokens;
		
		public UserSer() {}
		
		public UserSer(String line) {
			String[] newArray = line.split("\\|");
			this.setTokens(newArray.clone());

		    //System.out.println("*****************");
		    
			this.setId(Integer.parseInt(tokens[0]));
			this.setAge(tokens[1]);
			this.setGender(tokens[2]);
			this.setOccupation(tokens[3]);
			this.setZipCode(tokens[4]);
		}
		public UserSer(int id, String age, String gender, String occupation, String zipCode) {
			super();
			this.id = id;
			this.age = age;
			this.gender = gender;
			this.occupation = occupation;
			this.zipCode = zipCode;
		}
		public void toSerFile(String fileName) throws FileNotFoundException, IOException {
			// Stores 'this' user serially in the file of that name

		    ObjectOutputStream out = new ObjectOutputStream(new
		                                FileOutputStream(fileName));
		    out.writeObject(this);
		    out.close();
		}
		public void fromSerFile(String fileName) throws IOException {
			// Retrieves an object from that serial file.
			// Stores the data from that object in 'this' UserSer object
		    UserSer userToGet;
		    ObjectInputStream in = new ObjectInputStream(new 
		               FileInputStream(fileName));
		    try
		    {
		      userToGet = (UserSer)in.readObject();
		      //System.out.println(userToGet);
		      this.setId(userToGet.getId());
		      this.setAge(userToGet.getAge());
		      this.setGender(userToGet.getGender());
		      this.setOccupation(userToGet.getOccupation());
		      this.setZipCode(userToGet.getZipCode());
		    }
		    catch (Exception e)
		    {
		      System.out.println("Error in readObject: " + e);
		      System.exit(1);
		    }
		    in.close();
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


package Lab01;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainRanking {
	public static void main(String[] args) throws FileNotFoundException {
		int i = 0;
		Ranking[] allRankings = new Ranking[5];
		
		File inputFile = new File("ushort");
		Scanner fileContents = new Scanner(inputFile);
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking newMovie = new Ranking(line);
			allRankings[i] = newMovie;
			i ++;
		}
		fileContents.close();
		
		int maxValue = allRankings[0].getTimeStamp();
		for(int j = 1;j < allRankings.length; j++){
			if(allRankings[j].getTimeStamp() > maxValue){
				maxValue = allRankings[j].getTimeStamp();
				System.out.println("Lowest Time Stamp: " + allRankings[j]);
		    }
		}
		int minValue = allRankings[0].getTimeStamp();
		for(int k =1; k< allRankings.length; k++){
			if(allRankings[k].getTimeStamp() < minValue){
				minValue = allRankings[k].getTimeStamp();
				System.out.println("Highest Time Stamp: " + allRankings[k]);
		    }
		}
		System.out.println("*************************************");
	}
}

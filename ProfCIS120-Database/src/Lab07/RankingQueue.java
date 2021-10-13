package Lab07;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dale_Imports.*;

public class RankingQueue extends ArrayUnbndQueue<Ranking>
{
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking rankingObject = new Ranking(line);
			this.enqueue(rankingObject);
		}
		fileContents.close();
		
		//System.out.println(this.toString());
	}
	
	public double movieAvgRating (int movieId) {
		double sumAllRatings = 0.0;
		double totalNumRatings = 0.0;
		double avgRating = 0.0;
		// Creates a queue of RankingObjects with the specified movieId
		Ranking beginning = this.dequeue();
		
		if (movieId == beginning.getMovieId()) {
			sumAllRatings = sumAllRatings + beginning.getMovieRating();
			// Counts the number of ratings that enter the queue
			totalNumRatings++;
		  }
		this.enqueue(beginning);

		Ranking currentRanking = null;
		while (currentRanking != beginning) {
			currentRanking = this.dequeue();
			if (movieId == currentRanking.getMovieId()) {
				sumAllRatings = sumAllRatings + currentRanking.getMovieRating();
				// Counts the number of ratings that enter the queue
				totalNumRatings++;
			  }
			this.enqueue(currentRanking);

			}
		// Calculates the average rating
		avgRating = sumAllRatings / totalNumRatings;
		
		return avgRating;
	}
	
	public MovieLibrary findGoodType(MovieLibrary movieLibrary, String movieType, double minAvgRating) {
		// Retrieves a MovieLibrary containing Movies with the listed parameters
		MovieLibrary goodMovies = movieLibrary.findType(movieType);
		MovieLibrary movieHolder = new MovieLibrary();
		// Checks the average movie rating of each movie in the goodMovies library 
		// and removes those below minAvgRating
		while(!goodMovies.isEmpty()) {
			if (this.movieAvgRating(goodMovies.top().movieId) < minAvgRating) {
			goodMovies.pop();
			}
			else{
				movieHolder.push(goodMovies.top());
				goodMovies.pop();
			}
		}
		// Replace contents of goodMovies
		while(!movieHolder.isEmpty()) {
			goodMovies.push(movieHolder.top());
			movieHolder.pop();
		}
		
		return goodMovies;
	}
}
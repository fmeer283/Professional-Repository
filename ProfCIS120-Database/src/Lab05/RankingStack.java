package Lab05;
import Dale_Imports.*;

public class RankingStack extends LinkedStack<Ranking> {
	
	  public String toString() {
		  String str = recursiveReversePrint(top);
		  return str;
	  }
	  private String recursiveReversePrint(LLNode<Ranking> current) {
		  String str = "";
		  if(current == null) {
			  return str;
		  }
		  
		  str = str + current.getInfo().toString() + recursiveReversePrint(current.getLink());
		  return str;
	  }
	  
	  public int wrapper(int n) {
		  // Starts it off at the top
		  int howMany = recHighRatings(n, top);
		  return howMany;
	  }
	  // Returns how many of nodes from current back have a ranking of at least n
	  private int recHighRatings(int n, LLNode<Ranking> current) {
		  int howMany = 0;
		  // finds the back of the train
		  if (current == null)
			  return 0;
		  // looks inside current car
		  if (current.getInfo().getMovieRating() >= n)
			  howMany++;
		  // hands off the job of looking inside of the car behind
		  howMany = howMany + recHighRatings(n, current.getLink());

		  return howMany;
	  }
}

package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
//Stdev object implements runnable to use threads

public class Stdev implements Runnable{
	//variables for constructor, using the values shared globally
	double stdev;
	private ArrayList<Integer> numlist;
	//constructor for stdev object
	public Stdev(ArrayList<Integer> numlist, long stdev) {
		this.numlist=numlist;
		this.stdev=stdev;
	}
	//run method to compute calculation
	@Override
	public void run() {
		//calculating standard deviation by getting the average
		//then taking the square of the difference between the average and the array elements]
		//then taking the square root of the sum of those sqaured differences
		 double mean = 0;
		 for(int i=0;i<numlist.size();i++) {
			 mean+=numlist.get(i);
		 }
		 mean/=numlist.size();
		 double sqrdmean=0;
		 for(int j=0;j<numlist.size();j++)
			 sqrdmean=sqrdmean+Math.pow(numlist.get(j)-mean, 2);
		 stdev=(Math.sqrt(sqrdmean/numlist.size()));
	}

}

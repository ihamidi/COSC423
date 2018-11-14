package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
//Average object implements runnable to use threads
public class Avg implements Runnable{
	//variables for constructor, using the values shared globally
	private ArrayList<Integer> a;
	long avg;
	public long getAvg() {
		return avg;
	}
	//constructor for average object
	public Avg(ArrayList<Integer> numlist, long avg) {
		a=numlist;
		this.avg=avg;
	}
	//run method to compute calculation
	@Override
	public void run() {
		//calculating average by summing all elements of arraylist then dividing by its size
		for(int i=0;i<a.size();i++) {
			avg+=a.get(i);
		}
		avg /=a.size();
		//System.out.println("The average of these numbers is "+avg);
	}

}

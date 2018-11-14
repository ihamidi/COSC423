package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
//Max object implements runnable to use threads

public class Max implements Runnable {
	//variables for constructor, using the values shared globally
	private ArrayList<Integer> numlist;
	int max;
	
	public int getMax() {
		return max;
	}
	//constructor for max object
	public Max(ArrayList<Integer> numlist, int max) {
		this.numlist=numlist;
		this.max=max;
	}
	//run method to compute calculation
	@Override
	public void run() {
		//calculating max by setting first element to max and comparing it to the arraylist
		for(int i=0;i<numlist.size();i++)
		{
			if(max<numlist.get(i))
				max=numlist.get(i);
		}
		
	}

}

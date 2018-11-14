package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
//Mdn object implements runnable to use threads

public class Mdn implements Runnable{
	//variables for constructor, using the values shared globally
	private ArrayList<Integer> numlist;
	int mdn;
	//constructor for mdn object
	public Mdn(ArrayList<Integer> numlist, int mdn) {
		this.numlist=numlist;
		this.mdn=mdn;
	}
	//run method to compute calculation
	@Override
	public void run() {
		//sorting the array then taking the middle point (size/2)
		Collections.sort(numlist);
		mdn=numlist.get(numlist.size()/2);
	}

}

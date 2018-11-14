package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
//Min object implements runnable to use threads

public class Min implements Runnable{
	private ArrayList<Integer>numlist;
	int min;
	public int getMin() {
		return min;
	}
	//constructor for min object
	public Min(ArrayList<Integer> numlist, int min) {
		this.numlist=numlist;
		this.min=min;
	}
	//run method to compute calculation
	@Override
	public void run() {
		//calculating min by setting first element to min and comparing it to the arraylist
		for(int i=0;i<numlist.size();i++)
		{
			if(min>numlist.get(i))
				min=numlist.get(i);
		}
	}

}

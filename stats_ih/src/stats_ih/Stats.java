package stats_ih;
/*
 * Izhak Hamidi
 * COSC 423
 * Threads Programming assignment 
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Stats {

/*Main creates threads and takes user input
 * creates the threads
 * Then outputs the each calculation once all th4e threads have finished
 */
	public static void main(String[] args) {
		//creating variables to represent each result from calculations in the threads
		long avg = 0,stdev=0;
		int min,max,mdn = 0;
		//taking in input and storing it into arraylist
		Scanner nums= new Scanner(System.in);
		ArrayList<Integer>numlist= new ArrayList<Integer>();
		System.out.println("Input numbers to calculate the average, minimum, and maximum, when done type \".\" ");
		while(nums.hasNextInt())
		{
			
			numlist.add(nums.nextInt());
			
		}
		nums.close();
		//creation of threads
		min=numlist.get(0);
		max=numlist.get(0);
		//creating calculation objects
		Avg average=new Avg(numlist,avg);
		Min minimum= new Min(numlist,min);
		Max maximum= new Max(numlist, max);
		Mdn median= new Mdn(numlist,mdn);
		Stdev standarddev=new Stdev(numlist,stdev);
		//creating each thread to run the calculation
		Thread t1= new Thread(average);
		Thread t2= new Thread(minimum);
		Thread t3= new Thread(maximum);
		Thread t4= new Thread(median);
		Thread t5= new Thread(standarddev);
		//starting each thread
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		//waiting until all threads to complete to output the values
		while(!t1.isAlive()&&!t2.isAlive()&&!t3.isAlive()&&!t4.isAlive()&&!t5.isAlive())
		{
			

		}
		//output of average, min,max,standard deviation, and median
		System.out.println("The average of these numbers is "+average.avg);
		
		System.out.println("The smallest number in the list is "+minimum.min);
	
		System.out.println("The largest number in the list is "+maximum.max);
	
		System.out.println("The median is "+median.mdn);

		System.out.println("The standard deviation is "+standarddev.stdev);
	}

}

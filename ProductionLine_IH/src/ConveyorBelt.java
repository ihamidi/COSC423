/**
 * ConveyorBelt.java
 *
 * This program implements the bounded belt using Java synchronization.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * @version 1.1 - May, 2015 
 * Some modifications by Matt Evett  
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
 
public class ConveyorBelt  
{     
   public ConveyorBelt(int beltnum)
   {
      // belt is initially empty
      count = 0;
      in = 0;
      out = 0;
      //beltnumber to display
      this.beltnum=beltnum;
      //creating a coneyorbelt array
      belt = new Widget[BELT_SIZE];
   }

 // Workers will call this to nap
   public static void napping() {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*3000); }
     catch(InterruptedException e) { }
   }
   
   //Method to put widget in the belt
   public synchronized void enter(Widget item,String name) {
	   //if belt is full then print a message
	   while (count == BELT_SIZE) {
		   try {
				System.out.println("WARNING: Worker "+ name +" is waiting to put "+ item +"<handled by > on conveyer");  

			   wait();
		   }
		   catch (InterruptedException e) { }
	   }

	   // add an item to the belt
	   ++count;
	   belt[in] = item;
	   in = (in + 1) % BELT_SIZE;
	 //if belt is full then print a message
	   if (count == BELT_SIZE)
		   System.out.println("WARNING: Worker "+name+" cannot put " +item + " on belt #"+beltnum+" Conveyor FULL");
	   else
		   System.out.println("Worker "+name +" put " + item + " on belt #"+beltnum+" on the line. Conveyor Size = " +  count);

	   notify();
   }

   // consumer calls this method
   public synchronized Widget remove(String name) {
      Widget item;
      // if belt is empty, print what worker is waiting on belt
      while (count == 0) {
         try {
        	
        		 System.out.println("WARNING: Worker "+name +" is idle!");
				
        	 wait();
         }
         catch (InterruptedException e) { }
      }
      
      // remove an item from the belt
      --count;
      item = belt[out];
      out = (out + 1) % BELT_SIZE;
      //print message if belt is empty
	if (count == 0)
		System.out.println("Worker "+name +" took " + item + " off the belt#"+this.beltnum+". Conveyer EMPTY");
	else
		System.out.println("Worker "+name+" took " + item + " off the belt#"+this.beltnum+". Conveyer Size = " + count);

      notify();
      
      return item;
   }
   
   public static final int    NAP_TIME =2;
   private static final int   BELT_SIZE = 3;
   private int beltnum; //to tell apart of different belts
   private int count; // number of items in the belt
   private int in;   // points to the next free position in the belt
   private int out;  // points to the next full position in the belt
   private Widget[] belt;
}

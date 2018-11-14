/**
 * Factory.java
 *
 * This creates the buffer and the producer and consumer threads.
 *COSC423
 *Izhak Hamidi.
 */

public class Factory
{
	public static void main(String args[]) {
		
		//creating the conveyor belts
		ConveyorBelt con1= new ConveyorBelt(1);
		ConveyorBelt con2= new ConveyorBelt(2);
		ConveyorBelt con3= new ConveyorBelt(3);

      		// now create the producer and consumer threads
      		WorkerA A = new WorkerA(con1,"A");
      		WorkerMid B = new WorkerMid(con1,con2,"B");
      		WorkerMid C = new WorkerMid(con2,con3,"C");
      		WorkerD D = new WorkerD(con3,"D");
      
      		//starting all the worker threads
      		A.start();
      		B.start();
      		C.start();
      		D.start();
	}
}

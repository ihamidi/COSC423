/**
 * 
 * @author Izhak Hamidi
 * COSC423-ProductionLine
 * Matthew Evett
 */



public class WorkerD extends Thread 
{
	private final int PRODCOUNT=24;
	private ConveyorBelt buffer; //belt to take items off of
	private String name; // name of the worker
	//constructor for last worker
   public WorkerD(ConveyorBelt b,String name)
   {
      buffer = b;
      this.name=name;
   }
   
   public void run()
   {
	 Widget wid;
	 for(int i=1; i<=PRODCOUNT;i++){ // consume an item from the buffer
           //remove item from belt and handle it
         wid = (Widget)buffer.remove(name);
         System.out.println("Worker "+this.name+" is retrieving "+ wid +" from belt. <handled by "+wid.handled()+">");    	 ConveyorBelt.napping();
         try {
			Thread.sleep((long) (2000*Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //print out the finished widget
         System.out.println("Worker D Finished "+wid);
      }
	 System.out.println("Worker D is done!");
   }

}



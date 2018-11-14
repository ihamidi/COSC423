/**
 * 
 * @author Izhak Hamidi
 * COSC423-ProductionLine
 * Matthew Evett
 */

public class WorkerMid extends Thread{
	private final int PRODCOUNT=24;
	private  ConveyorBelt feedbelt;  //belt to take items off of
	private  ConveyorBelt producebelt;  //belt to put handled items on
	private  String name;	//name of worker
	//constructor for middle worker, has two belts
	public WorkerMid(ConveyorBelt bstart,ConveyorBelt bend, String name) {
		 feedbelt=bstart;
		 producebelt=bend;
		 this.name=name;
		 
	}
	public void run()
	{
		Widget wid;

		for(int i=1; i<=PRODCOUNT;i++){
			ConveyorBelt.napping();	   
			//take a widget off the line and handle
			wid = (Widget)feedbelt.remove(name);
			System.out.println("Worker "+this.name+" is retrieving "+ wid +" from belt. <handled by "+wid.handled()+">");
			wid.handle(name);

			 try {
					Thread.sleep((long) (2000*Math.random()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
			 //put the widget onto next belt
			producebelt.enter(wid,name);
		}
		System.out.println("Worker "+this.name+" has finished!");
	}
	
}

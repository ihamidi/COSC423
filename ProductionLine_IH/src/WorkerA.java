/**
 * 
 * @author Izhak Hamidi
 * COSC423-ProductionLine
 * Matthew Evett
 */

public class  WorkerA  extends Thread{
	   
	private  ConveyorBelt buffer;	//belt to produce widgets on put on
	public String myName;			//Name of worker
	private final int PRODCOUNT=24; //count for the amount of widgets program will rpoduce
	
	public WorkerA( ConveyorBelt b,String name){
		buffer = b;
		myName = name;
	}
	
	public void run(){
     
		for(int i=1; i<=PRODCOUNT;i++){
			ConveyorBelt.napping();
				
			// produce a widget and send it into the conveyer belt
			Widget w = new Widget(i);
			w.handle(myName);
			System.out.println("Worker A is working on the "+ w +" <handled by "+w.handled()+">");
			  try {
					Thread.sleep((long) (2000*Math.random()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			buffer.enter(w,myName);
		}
		System.out.println("Worker A is done!");
	}

}
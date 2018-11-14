/**
 * 
 * @author Izhak Hamidi
 * COSC423-ProductionLine
 * Matthew Evett
 */

import java.util.ArrayList;
/*
 * Widget Class, elemnt that go on the conveyor belt 
 * 
 */
public class Widget {
	private int num;	//to identify different widget objects
	private ArrayList<String> handledBy = new ArrayList<String>(); //keep track of what workers handled the widget
	//constructor for the Widget class
	public Widget (int num) {
		this.num=num;
		
	}
	public int getNum() {
		return num;
	}
	//handle method to add a worker who handled it and keep track of who did.
	public void handle(String h) {
	        handledBy.add(h);
	    }
	//returns the Workers tahat handled that object
	public String handled()
	{
		String s="";
		for(int i=0;i<handledBy.size();i++)
		{
			s+=handledBy.get(i)+", ";
		}
		return s;
	}
	//tostring to return the widget number
	public String toString()
	{
		return "widget #"+num;
		
	}
	
}

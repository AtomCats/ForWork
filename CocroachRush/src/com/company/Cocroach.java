package com.company;

import java.io.IOException;

public class Cocroach implements Runnable{
    private Judge judge;
    private int idCount=0,counter;
    private final int id;
    public boolean running=true;
    public Cocroach(Judge judge){
        this.judge=judge;
        id=judge.getCount();
    }
    
    
    public void run(){
    	Judge.test++;
    	System.out.print("\n");
    	try{
			while(counter!=10000){
				running=judge.start(id,running,counter);
				Thread.sleep(2);
				counter++;
			}
			running=judge.stop(id,running);
			counter=0;		
			//Thread.yield();
		}
    	catch(InterruptedException e){
    		//System.out.println("\n"+id+" was interrupted");
    	}

    }
}

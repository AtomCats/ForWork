package com.company;

public class Cocroach implements Runnable{
    private Judge judge;
    private int idCount=0;
    private final int id;
    public boolean running=true;
    public Cocroach(Judge judge){
        this.judge=judge;
        id=judge.getCount();
    }
    
    
    public void run(){
    	Judge.test++;
		while(idCount==0){
			if(running==true){
				running=judge.start(id,running);
			}
			running=judge.stop(id,running);

		}
    }
}

package com.company;
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Judge{
	public static int test=0;
    volatile Boolean allHere=false;
    volatile Boolean running = true;
    private volatile int counter=0;
    private int threadCounter;
    private int idCount=0;
    private int round;
    public  LinkedList<String> results = new LinkedList<String>();
	public  ListIterator<String> iterator = results.listIterator();
    ReentrantLock locker;
    Condition condition;

    Judge(){
    	
        locker = new ReentrantLock();
        condition = locker.newCondition();
        idCount++;
        
    }

    public int getCount(){
    	
        return idCount++;
        
    }


    public synchronized boolean  start(int id,boolean run){
    	
        try{
        	
            while(run==false){
            	
                wait();
                
            }
            
            running=true;
            System.out.println("Cocroach #"+id+" is running");
            Thread.sleep(1000);
             run=false;

        }
        
        catch(InterruptedException e){
        	
        }

        return run;
    }

    public synchronized boolean stop(int id,boolean run){

            if (run == true) {
            	
                notifyAll();
                
            }
            
            if(ready(id)==false){
            	
                System.out.println("Cocroach #" + id + " has finished");
    			results.add(Integer.toString(id));
                counter++;
/*    			try {
    				
					wait();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}*/
            }
            
            int numCount=0;
			
            if (allDone() == true) {
            	
            	for(String s:results){
            		
    				numCount++;
    				System.out.println("Cocroach # "+s+" finished with number "+numCount);
            	}
            	
                run = true;
                results.clear();
/*                for(String s : results){
                	results.remove();
                }*/
                notifyAll();
            }
            return run;
    }


    public  boolean allDone(){
    	
        if(counter==(idCount-1)){
        	
            counter=0;
            threadCounter=0;
            //notifyAll();
            return true;
            
        }
        else {
            return false;
        }
    }
    
    public boolean ready(int id){
    	
		if(results.contains(""+id)){
			
			return true;
			
		}
		
		else {
			
			return false;
		}


    }
    

}
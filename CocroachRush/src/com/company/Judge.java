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
    private int round,bufCounter= 0;
    private String buffer[][]=new String[6][101];
    public  LinkedList<String> results = new LinkedList<String>();
    private List<String> res = new LinkedList<String>();
	public  ListIterator<String> iterator = results.listIterator();
    ReentrantLock locker;
    Condition condition;

    Judge(){
    	
        idCount++;
/*        for(int i=0;i<1;i++){
        	for(j=0;j<5;j++){
        		buffer[i][j]=;
        	}
        }*/
        
    }

    public int getCount(){
    	buffer[idCount-1][0]=""+(idCount);
        return idCount++;
        
    }
    
    public void printResult(){
    	for(String s:res){
    		System.out.println(s);
    	}

    }
    
    public void printProgress(){
       	System.out.println("\n \\------------------------------------------// \n");
        	for(int i=0;i<5;i++){
        		for(int j=0;j<100;j++){
        			if(buffer[i][j]!=null){
            		System.out.print(buffer[i][j]);
        			}
        		}
        		System.out.println("\n");
        	}

    }


    public synchronized boolean  start(int id,boolean run,int counter){
    	if(counter%100==0){
            try{
            	round++;
            	bufCounter=counter/100;
                while(run==false){
                	
                    wait();
                    
                }
                
                	buffer[id-1][bufCounter+1]="#";
                	
                 //run=false;
                
            }
            
            catch(InterruptedException e){
            	
            }
    	}
    	else if(counter==9999){
    		run=false;
    	}

        return run;
    }

    public synchronized boolean stop(int id,boolean run){

            if (run == true) {
            	
                notifyAll();
                
            }
            
            if(ready(id)==false){
            	
                //System.out.print("\n Cocroach #" + id + " has finished \n");
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
    				res.add("Cocroach # "+s+" finished with number "+numCount+"\n");
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
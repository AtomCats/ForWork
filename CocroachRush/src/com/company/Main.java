package com.company;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Judge Dredd=new Judge();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        System.out.println("###Start###");
        for(int i =0;i<5;i++){
            exec.execute(new Cocroach(Dredd));
        }
        while(exec.isTerminated()==false){
        	Dredd.printProgress();
        	Thread.sleep(1);
        	exec.shutdown();;
        }
        Dredd.printResult();
        
    }
}


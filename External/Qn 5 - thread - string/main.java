/* Create 2 threads, one for reading a string and another for printing the strong Initially, it should prim "Hello World". Once the user enters the string, that string should be primed. The printing thread should print the same string every 1 sec. */


import java.io.*;
import java.util.*;

class Thread1 extends Thread{
    public void run(){
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
    }
}

class Thread2 extends Thread{
    public void run(){
        while(true){
            System.out.println("Hello World");
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                    System.out.println(e);
            }
        }
    }
}
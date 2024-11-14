class MyThread1 extends Thread{
    public void run(){
        int i = 0;
        while(i < 400){
            System.out.println("Thread1 is running");
            i++;
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        int i = 0;
        while(i < 400){
            System.out.println("Thread2 is running");
            i++;
        }
    }
}

class MyThread3 implements Runnable{
    public void run(){
        int i = 0;
        while(i < 400){
            System.out.println("Thread3 is running");
            i++;
        }
    }
}

public class main{
    public static void main(String[] args){
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        MyThread3 t3 = new MyThread3();
        Thread t4 = new Thread(t3);
        t1.start();
        t2.start();
        t4.start();
    }
}
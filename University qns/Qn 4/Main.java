import java.util.*;

class mainthread extends Thread{
    public static int num;
    public void run(){
    Random random = new Random();

    while(true){
        num = random.nextInt(100) + 2;
        System.out.println(num);
        try {
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
}

class eventhread extends Thread{
    public void run(){
        while(true){
            synchronized (mainthread.class) {
                if(mainthread.num % 2 == 0){
                    int i;
                    for(i = 2; i < mainthread.num; i = i + 2){
                        System.out.println(i+" ");
                    }
                }
            }
            try {
                    Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}

class oddthread extends Thread{
    public void run(){
        while(true){
            synchronized (mainthread.class) {
                if(mainthread.num % 2 != 0){
                    int i;
                    for(i = 1; i < mainthread.num; i = i + 2){
                        System.out.println(i+" ");
                    }
                }
            }
            try {
                    Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}

public class main{
    public static void main(String[] args) {
        mainthread numb = new mainthread();
        eventhread even = new eventhread();
        oddthread odd = new oddthread();
        numb.start();
        even.start();
        odd.start();
    }
}
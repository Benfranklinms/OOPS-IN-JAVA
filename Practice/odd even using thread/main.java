import java.util.*;


class Thread1 extends Thread{
    public void run(){
        int i;
        System.out.print("Enter a number : ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        for(i = 0; i < n1; i++){
            if(i % 2 == 0){
                System.out.println( "Even : " + i + " ");
            }
        }
    }
}

class Thread2 extends Thread{
    public void run(){
        int i;
        System.out.print("Enter a number : ");
        Scanner sc = new Scanner(System.in);
        int n2 = sc.nextInt();
        for(i = 0; i < n2; i++){
            if(i % 2 != 0){
                System.out.println( "Odd : " + i + " ");
            }
        }
    }
}

public class main{
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}
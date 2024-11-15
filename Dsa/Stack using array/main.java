import java.io.*;
import java.util.*;

public class main{
    int MAX = 5;
    int item;
    int[] stack = new int[MAX];
    int top = -1;

    
    public void push(int item){
        if(top == MAX - 1){
            System.out.println("Stack overflow");
        }
        else{
            top++;
            stack[top] = item;
        }
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack underflow");
        }

        else{
            item = stack[top];
            top--;
        }
        return item;
    }

    public void display(){
        int i;
        for(i = 0; i <= top; i++){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        main stackInstance = new main();

        int n, choice;
        while(true){
            System.out.println("\n1.Push\n2.Pop\n3.Display\n4.Exit");
            System.out.print("Enter a choice : ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            int item;
    
            switch(choice){
                case 1:
                    System.out.print("Enter the item to be pushed : ");
                    item = sc.nextInt();
                    stackInstance.push(item);
                    break;
                case 2:
                    item = stackInstance.pop();
                    System.out.println("Popped item is : " + item);
                    break;
                case 3:
                    System.out.println("Stack elements are : ");
                    stackInstance.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Enter correct options");
            }
        }
        }
}




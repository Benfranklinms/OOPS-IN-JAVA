package mypackage;


import java.util.*;
import java.io.*;

interface MyInterface{
    void display();
    void showMessage(String message);
}

public class main implements MyInterface{
    public void display(){
        System.out.println("Hello, World!");
    }
    public void showMessage(String message){
        System.out.println(message);
    }

public static void main(String args[]){
    main obj = new main();
    obj.display();
    obj.showMessage("Hello, World");
}
}
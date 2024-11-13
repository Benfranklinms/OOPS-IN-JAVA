import java.io.*;
import java.util.*;

abstract class Marks{
    abstract double getPercentage();
}

class StudentA extends Marks{
    private double mark1, mark2, mark3;
    public StudentA(double mark1, double mark2, double mark3){
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }
    public double getPercentage(){
        return ((mark1 + mark2 + mark3) / 3);
    }
}

class StudentB extends Marks{
    private double mark1, mark2, mark3, mark4;
    public StudentB(double mark1, double mark2, double mark3, double mark4){
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
    }
    public double getPercentage(){
        return ((mark1 + mark2 + mark3 + mark4) / 4);
    }
}

public class main{
    public static void main(String args[]){
        StudentA studentA = new StudentA(90, 80, 70);
        StudentB studentB = new StudentB(80,90,99,95);
        System.out.println("Percentage of student1 is : " +studentA.getPercentage());
        System.out.println("Percentage of student2 is : " +studentB.getPercentage());
    }
}
/* Write a program to read the first n characters in a file where n is given by the (7)
user. The characters read from file has to be reversed and displayed on
screen. Built in methods can be used in the program. */

import java.io.*;
import java.util.*;


public class main{
    public static void main(String args[]){
        File f1 = new File("source.txt");
        File f2 = new File("destination.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(f1));
            bw = new BufferedWriter(new FileWriter(f2));
            int n;
            int i;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of characters to be read:");
            n = sc.nextInt();
            char[] ch = new char[n];
            int charsread = br.read(ch, 0, n);
            String original = new String(ch, 0, charsread);
            String reversed = new StringBuilder(original).reverse().toString();
            bw.write(reversed);
            System.out.println("Reversed string is: " + reversed);
        }

        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    try{
        br.close();
        bw.close();
    }
    catch(IOException e){
        System.out.println("Error: " + e.getMessage());
    }
    
}
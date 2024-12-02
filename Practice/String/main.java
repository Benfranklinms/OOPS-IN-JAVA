package Practice.String;

import java.util.*;
import java.io.*;

public class main{
    public main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] word = new String[0];
        int i;
        for(i = 0; i < 5; i++){
            word[i] = sc.nextLine();
        }
        for(i = 0; i < 5; i++){
            String reversed = new StringBuilder(word[i]).reverse().toString();
        }
        System.out.println("Reversed word : "+ reversed);
    }
}
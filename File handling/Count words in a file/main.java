import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class main{
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            String line;

            while((line = br.readLine()) != null){
                int count = 0;
                String[] words = line.split(" ");
                count = count + words.length;
                bw.write(count + "");
            }
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
}
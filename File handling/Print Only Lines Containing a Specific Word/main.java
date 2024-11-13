import java.io.*;
import java.util.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("source.txt");
        File file2 = new File("destination.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        System.out.print("Enter a word : ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        try{
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            String line;

            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                for(String next : words){
                    if(next.equals(word)){
                        bw.write(line);
                        bw.newLine();
                        break;
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try{
            br.close();
            bw.close();
        }
        
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
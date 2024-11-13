import java.util.*;
import java.io.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("source.txt");
        File file2 = new File("destination.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;
        ArrayList<String> words = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            String line;

            while((line = br.readLine()) != null){
                String[] wordArray = line.split(" ");
                Collections.addAll(words, wordArray);
            }
            Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

            for(String word: words){
                bw.write(word);
                bw.newLine();
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
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.util.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("source.txt");
        File file2 = new File("destination.txt");
        Scanner sc = new Scanner(System.in);

        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            String line;
            System.out.print("Enter word to replace : ");
            String search = sc.nextLine();
            System.out.print("Enter word to replace with : ");
            String replace = sc.nextLine();
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                int i;
                StringBuilder newLine = new StringBuilder();
                for(i = 0; i < words.length; i++){
                    if(words[i].equals(search)){
                        newLine.append(replace);
                    }
                    else{
                        newLine.append(words[i] + " ");
                    }
                }
                bw.write(newLine + " ");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            br.close();
            bw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
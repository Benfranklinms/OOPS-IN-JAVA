/* Read a line of words using StringTokenizer, write the sorted words in "sortedwords.
txt".The name of file must be given as command Line argument. Also print the no of
words in the file.
eg: my name is George
Output in the terminal:" Number of words in sortedwords.text file=4".
Inside the file: George
is
my
name */

import java.io.*;
import java.util.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("sorted.txt");

        BufferedWriter bw = null;
        Scanner sc = null;

        try{
            bw = new BufferedWriter(new FileWriter(file1));
            sc = new Scanner(System.in);
            System.out.print("Enter a line of words : ");
            String line = sc.nextLine();

            StringTokenizer str = new StringTokenizer(line);

            ArrayList<String> words = new ArrayList<>();
            while(str.hasMoreTokens()){
                words.add(str.nextToken());
            }
            Collections.sort(words);

            for(String word : words){
                bw.write(word);
                bw.newLine();
            }

            System.out.println("No. of words in the file is " + words.size());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            bw.close();
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }
}
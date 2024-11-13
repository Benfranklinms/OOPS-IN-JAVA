import java.io.*;

public class main{
    public static void main(String args[]){
        File file = new File("source.txt");
        int[] charCount = new int[256];

        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(file));

            String line;

            while((line = br.readLine()) != null){
                int i;
                for(i = 0; i < line.length(); i++){
                    int ch = line.charAt(i);
                    charCount[ch]++;
                }

                for(i = 0; i < charCount.length; i++){
                    if(charCount[i] > 0){
                    System.out.println((char)i+ " : "+charCount[i]);
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        try{
            br.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
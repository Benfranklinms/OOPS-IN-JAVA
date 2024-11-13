import java.io.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("source.txt");
        File file2 = new File("destination.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));

            String line;
            String longestline = "";
            int max = 0;
            int i;

            while((line = br.readLine()) != null){
                if(line.length() > max){
                    max = line.length();
                    longestline = line;
                }
                }
                bw.write(longestline);
                bw.newLine();
                
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
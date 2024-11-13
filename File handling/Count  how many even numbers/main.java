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
            int count = 0;

            while((line = br.readLine()) != null){
                try{
                    int number = Integer.parseInt(line.trim());

                    if(number % 2 == 0){
                        count++;
                    }
                }
                catch(NumberFormatException e){
                    e.printStackTrace();
                }
            }
            bw.write("Total no. of even : "+count);
            bw.newLine();
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
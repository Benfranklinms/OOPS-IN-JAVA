import java.io.*;

public class main{
    public static void main(String args[]){
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("output.txt");

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;

        try{
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            bw = new BufferedWriter(new FileWriter(file3));

            String line;

            while((line = br1.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
            while((line = br2.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            if(br1 != null) br1.close();
            if(br2 != null) br2.close();
            if(bw != null) bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
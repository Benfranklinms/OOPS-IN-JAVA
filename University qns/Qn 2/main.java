
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// Write Java code that reads a character file and prints the contents of file on the
// display, with a line number before each line.

public class main{
    public static void main(String[] args) {
        File f1 = new File("source.txt");
        File f2 = new File("destination.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(f1));
            bw = new BufferedWriter(new FileWriter(f2));
            String line;
            int linenumber = 1;

            while((line = br.readLine()) != null){
                bw.write(linenumber+ " " + line);
                linenumber++;
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
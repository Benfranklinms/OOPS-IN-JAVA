import java.io.FileInputStream;
import java.io.FileOutputStream;

public class main{
    public static void main(String[] args) {
        FileInputStream f1 = null;
        FileOutputStream f2 = null;

        try {
            f1 = new FileInputStream("source.txt");
            f2 = new FileOutputStream("destination.txt");
            int bytereader;
            while((bytereader = f1.read()) != -1){
                f2.write(bytereader);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            f1.close();
            f2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
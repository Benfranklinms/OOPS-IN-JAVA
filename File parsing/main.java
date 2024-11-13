import java.io.*;

public class main{
    public static void main(String args[]){
        File file = new File("numbers.txt");
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));

            String content = null;
            while((content = br.readLine()) != null){

                String[] number = null;
                if(content != null){
                   number = content.trim().split("\\s+");
                }
                int i;
                for(i = 0; i < number.length; i++){
                    try{
                        int num = Integer.parseInt(number[i]);
                        System.out.println(num);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Invalid number at position " + i);
                    }
                }
            }
        }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
    }
}
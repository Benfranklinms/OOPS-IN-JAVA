import java.util.*;
import java.io.*;

public class main{
        public static boolean isPalindrome(int num){
            int original = num;
            int reverse = 0;
            while(num > 0){
                int digit = num % 10;
                reverse = reverse * 10 + digit;
                num = num / 10;
            }
            return original == reverse;
        }
    
        public static int Sum(int num){
            int sum = 0;
            while(num > 0){
                sum = sum + num % 10;
                num = num / 10;
            }
            return sum;
        }
        public static void main(String[] args) {
            File file = new File("source.txt");
    
            BufferedWriter bw = null;
    
    
            try{
                bw = new BufferedWriter(new FileWriter(file));
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a random number : ");
                String n1 = sc.nextLine();
                StringTokenizer str = new StringTokenizer(n1);
                String line;
                while(str.hasMoreTokens()){
                    int num = Integer.parseInt(str.nextToken());
                    if(isPalindrome(num)){
                        bw.write("Palindrome : " + num);
                        bw.newLine();
                    }
    
                    int add = Sum(num);
                bw.write("Sum : " + add);
            }
        }
        catch(IOException e){
            System.out.println("Error : " + e.getMessage());
        }
        try{
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
import java.util.*;

public class main{
    public static void main(String[] args) {
        StringTokenizer str = new StringTokenizer("Hello world is nice right");

        while(str.hasMoreTokens()){
            System.out.println(""+ str.nextToken());
        }
    }
}
import java.util.*;
import java.io.*;


public class main{
    public int binarySearch(int a[], int n, int item){
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;

        while(low <= high){
            if(a[mid] == item){
                return mid;
            }
            else if(a[mid] < item){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        main search = new main();
        int element;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        int i;
        System.out.print("Enter elements into array : ");
        for(i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.print("Enter an element to search : ");
        element = sc.nextInt();
        int result = search.binarySearch(a, n, element);
        System.out.println("Element " + element + " is found at "+ (result + 1));
    }
}
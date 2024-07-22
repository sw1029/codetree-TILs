import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(), n = scan.nextInt();
        
        arr = new String[(int)Math.pow(k, n)];
        
        num(k,n,0,"");
        for(int i = 0; i < arr.length; i++) {
        	System.out.println(arr[i]);
        }
    }
	static int count = 0;
	static String[] arr;
    static void num(int k, int n, int c, String st){
        if(c == n) {
        	arr[count] = st;
        	count+=1;
        	return;
        }
        for(int i = 1; i <= k; i++) {
        	num(k,n,c+1,st + i+ " ");
        }
    	
    }
}
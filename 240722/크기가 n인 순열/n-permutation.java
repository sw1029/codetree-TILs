import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        boolean [] arr = new boolean[n];
       num(n, "", 0,arr);
       
    }
	static void num(int n, String st, int ac,boolean [] arr) {
		if(ac == n) {
			System.out.println(st);
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!arr[i-1]) {
				arr[i-1] = true;
				boolean [] nArr = arr.clone(); 
				num(n,st + i + " ",ac+1,nArr);
				arr[i-1] = false;
			}
		}
	}
	
	
	
}
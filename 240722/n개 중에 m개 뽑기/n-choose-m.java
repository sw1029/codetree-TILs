import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
            
        num(1,n,m,"",0);
       
    }
	static int count = 0;
	static void num(int start, int end,int m, String st,int ac) {
		if(ac == m) {
			System.out.println(st);
			return;
		}
		for(int i = start; i <= end; i++) {
			num(i+1,end,m,st + i + " ",ac+1);
		}
		
	}
	
	
}
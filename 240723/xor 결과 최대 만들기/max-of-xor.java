import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(),m = scan.nextInt();
        
        int []nums = new int[n];
        
        Stack<Integer>st = new Stack<>();
        
        
        for(int i = 0; i < n;i++)nums[i]=scan.nextInt();
        
        num(m,nums,st,0,n-1,0,0);
        System.out.println(max);
       
    }
	static int max = 0;
	static void num(int m, int[]nums, Stack <Integer>st, int start, int end,int count,int xor) {
		if(count>=m) {
			max = Math.max(max, xor);
			return;
		}
		for(int i = 0; i <= end; i++) {
			if(!st.contains(i)) {
				st.push(i);
				if(count == 0)num(m,nums,st,i+1,end,count+1,nums[i]);
				else num(m,nums,st,i+1,end,count+1,xor ^ nums[i]);
			}
			if(!st.isEmpty())st.pop();
		}
		
	}
	
	
	
}
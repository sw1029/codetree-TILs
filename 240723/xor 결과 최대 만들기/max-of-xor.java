import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]),m = Integer.parseInt(inp[1]);
        
        int []nums = new int[n];
        
        Stack<Integer>st = new Stack<>();
        
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n;i++)nums[i]=Integer.parseInt(input[i]);
        
        num(m,nums,st,0,n-1,0,0);
        System.out.println(max);
       
    }
	static int max = 0;
	static void num(int m, int[]nums, Stack <Integer>st, int start, int end,int count,int xor) {
		if(count>=m) {
			max = Math.max(max, xor);
			return;
		}
		for(int i = start; i <= end; i++) {
			if(!st.contains(i)) {
				st.push(i);
				if(count == 0)num(m,nums,st,i+1,end,count+1,nums[i]);
				else num(m,nums,st,i+1,end,count+1,xor ^ nums[i]);
			}
			if(!st.isEmpty())st.pop();
		}
		
	}
	
	
	
}
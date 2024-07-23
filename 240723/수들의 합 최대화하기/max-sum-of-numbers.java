import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int [] [] map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	String [] inp = br.readLine().split(" ");
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(inp[j]);
        	}
        }
        
        Stack<Integer> st = new Stack<>();
        mNum(n,0,map,0,st);
        
		System.out.println(max);
       
    }
	static int max = 0;
	
	static void mNum(int n, int count, int[][] map, int sum,Stack<Integer>st) {
		if(count >= n) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0;i < n; i++) {
			if(!st.contains(i)) {
				st.push(i);
				mNum(n,count+1,map,sum+map[count][i],st);
				st.pop();
			}	
		}
	}
	
	
	
}
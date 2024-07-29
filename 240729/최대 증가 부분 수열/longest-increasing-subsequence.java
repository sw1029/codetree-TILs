import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		nums = new int [n];
		mlen = new int[n];
		trv = new boolean[n];
		String [] inp = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(inp[i]);
		}
		mlen[n-1] = 1;
		trv[n-1] = true;
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(lenCount(i), max);
		}
		System.out.println(max);
    }
	static int [] nums;
	static int [] mlen;
	static boolean [] trv;
	
	static int lenCount(int n) {
		if(!trv[n]) {
			trv[n] = true;
			int max = 0;
			for(int i = n+1; i < mlen.length;i++) {
				if(nums[i] > nums[n]) {
					max = Math.max(lenCount(i), max);
				}
			}
			mlen[n] = max+1;
		}
		return mlen[n];
	}
}
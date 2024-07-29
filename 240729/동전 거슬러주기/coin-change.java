import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		
		String [] inp = br.readLine().split(" ");
		coin = new int [n];
		trv = new boolean[m];
		nums = new int[m];
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(inp[i]);
		}
		for(int i = 0; i < m; i++) {
			nums[i] = -1;
		}
		for(int i = 0; i < n; i++) {
			trv[coin[i]-1] = true;
			nums[coin[i]-1] = 1;
		}
		
		System.out.println(nc(m-1));
		
    }
	static int []coin;
	static boolean [] trv;
	static int [] nums;
	
	static int nc(int n) {
		if(!trv[n]) {
			//System.out.println("visited " + (n+1));
			trv[n] = true;
			ArrayList<Integer>nList = new ArrayList<>();
			for(int i = 0; i < coin.length; i++) {
				int k = n - coin[i];
				if(k >= 0) nList.add(nc(k));
			}
			Collections.sort(nList);
			int nNum = 0;
			if(nList.size()!=0)nNum = nList.get(0);
			nums[n] = nNum + 1;
		}
		return nums[n];
	}
}
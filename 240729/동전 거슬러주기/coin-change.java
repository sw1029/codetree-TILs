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
			int k = coin[i] - 1;
			trv[k] = true;
			nums[k] = 1;
		}
		
		if(nc(m-1)==0)System.out.println(-1);
		else System.out.println(nums[m-1]);
		
    }
	static int []coin;
	static boolean [] trv;
	static int [] nums;
	
	static int nc(int n) {
		if(!trv[n]) {//방문하지 않았을 경우
			trv[n] = true;
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < coin.length;i++) {
				int k = n - coin[i];
				if(k >= 0 && nc(k)!= -1) {
					arr.add(nc(k));
				}
			}
			if(arr.size() == 0)return -1;
			Collections.sort(arr);
			nums[n] = arr.get(0) + 1;
			
		}
		return nums[n];
	}
}
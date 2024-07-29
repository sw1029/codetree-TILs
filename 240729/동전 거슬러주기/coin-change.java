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
		
		if(nc(m-1)==0)System.out.println(-1);
		else System.out.println(nums[m-1]);
		
		
    }
	static int []coin;
	static boolean [] trv;
	static int [] nums;
	
	static int nc(int n) {
		if(!trv[n]) {//방문하지 않았을 경우
			trv[n] = true;
			ArrayList<Integer>nList = new ArrayList<>();//코인으로 갈 수 있는 경우의 수 list
			for(int i = 0; i < coin.length; i++) {
				int k = n - coin[i];
				if(k >= 0) nList.add(nc(k));//배열에 더하기
			}
			Collections.sort(nList);//크기순 정렬
			int nNum = 0;
			if(nList.size()!=0)nNum = nList.get(0);
			if(n!=0)nums[n] = nNum+1;
		}
		return nums[n];
	}
}
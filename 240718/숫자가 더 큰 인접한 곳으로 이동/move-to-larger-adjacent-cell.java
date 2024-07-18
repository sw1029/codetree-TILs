import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
		
		int [] [] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String [] inp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}

		if(n==1){
			System.out.print(map[0][0]);
			return;
		}
		//r행c열에서 시작
		
		
		
		
		while(true) {
			bw.write(map[r-1][c-1] + " ");
			if(r!=1 && map[r-1][c-1]<map[r-2][c-1]) {//north
				r--;
			}else if(r!=n && map[r-1][c-1] < map[r][c-1]) {//south
				r++;
			}else if(c!=1 && map[r-1][c-1] < map[r-1][c-2]) {//west
				c--;
			}else if(c!=n && map[r-1][c-1] < map[r-1][c]) {//east
				c++;
			}else break;//더이상 동작이 불가능한 경우
		}
		bw.flush();
		
	}

	
	
}
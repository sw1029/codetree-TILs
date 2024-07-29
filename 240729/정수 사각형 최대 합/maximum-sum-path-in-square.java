import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		sumMap = new int [n+2][n+2];
		trv = new boolean [n+2][n+2];
		
		for(int i = 1; i <= n; i++) {
			String [] inp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j+1] = Integer.parseInt(inp[j]);
			}
		}
		for(int i = 0; i < n+2; i++) {
			trv[0][i] = true;
			trv[i][0] = true;
		}
		sumMap[1][1] = map[1][1];
		trv[1][1] = true;
		System.out.println(sq(n,n));
		
    }
	static int [][] map;
	static int [][] sumMap;
	static boolean [][]trv;
	
	static int sq(int r, int c) {
		if(!trv[r][c]) {
			trv[r][c] = true;
			if(r == 1)sumMap[r][c] = map[r][c] + sq(r,c-1);
			else if(c == 1)sumMap[r][c] = map[r][c] + sq(r-1,c);
			else sumMap[r][c] = map[r][c] + Math.max(sq(r-1,c), sq(r,c-1));
		}
		return sumMap[r][c];
	}
	
}
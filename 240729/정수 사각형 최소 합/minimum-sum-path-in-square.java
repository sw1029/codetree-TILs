import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
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
		sumMap[1][n] = map[1][n];
		trv[1][n] = true;
		System.out.println(sq(n,1));
		
    }
	static int [][] map;
	static int [][] sumMap;
	static boolean [][]trv;
	static int n;
	static int sq(int r, int c) {
		if(!trv[r][c]) {
			trv[r][c] = true;
			if(r==1 || c == n) {
				if(r==1)sumMap[r][c] = map[r][c] + sq(r,c+1);
				if(c==n)sumMap[r][c] = map[r][c] + sq(r-1,c);
			}
			else sumMap[r][c] = map[r][c] + Math.min(sq(r-1,c), sq(r,c+1));
		}
		return sumMap[r][c];
	}
	
}
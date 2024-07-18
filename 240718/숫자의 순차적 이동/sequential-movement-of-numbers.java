import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), count = 1;
		
		int [][]map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String [] inp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}
		
		for(int o = 0; o < m; o++) {//m번 반복
			while(count <= n*n) {
				int r=-1,c=-1;
				
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n;j++) {
						if(map[i][j]==count) {
							r=i;
							c=j;
						}
					}
					
				}//원하는 블럭의 위치 확인
				
				int sr = r-1, er = r+1, sc = c-1, ec = c+1;
				//시작과 끝 
				
				if(r==0)sr=r;
				if(r==n-1)er=r;
				if(c==0)sc=c;
				if(c==n-1)ec=c;
				int max = 0;
				
				
				
				for(int i = sr; i <= er;i++) {
					for(int j = sc;j<=ec;j++) {
						if(!(i==r && j ==c)) {
							max = Math.max(max, map[i][j]);
						}
					}
				}
				
				
				
				for(int i = sr; i <= er;i++) {
					for(int j = sc;j<=ec;j++) {
						if(map[i][j]==max) {
							int temp = map[r][c];
							map[r][c] = map[i][j];
							map[i][j] = temp;
							
							i+=20;
							j+=20;
						}
					}
				}
				
				
				count++;
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	
	
}
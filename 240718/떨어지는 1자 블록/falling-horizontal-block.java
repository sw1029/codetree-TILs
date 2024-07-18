import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);
		
		int [] [] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String [] inp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}
		for(int i = 0; i < n ;i++) {
			for(int j = k-1;j < k+m-1;j++) {
				if(map[i+1][j]==1 || i == n-1) {
					for(int l = k-1; l < k+m-1; l++) {
						map[i][l] = 1;
						
					}
					
					for(int p = 0; p < n; p++) {
						for(int q = 0; q < n; q++) {
							bw.write(map[p][q]+" ");
						}
						bw.write("\n");
					}
					bw.flush();
					
					return;
					
				}
			}
		}
		
		for(int p = 0; p < n; p++) {
			for(int q = 0; q < n; q++) {
				bw.write(map[p][q]+" ");
			}
			bw.write("\n");
		}
		
		
		
		bw.flush();

	}

}
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), t = Integer.parseInt(input[2]);
		boolean [][]ballMap = new boolean[n][n];
		
		int [][]map = new int [n][n];
		
		for(int i = 0; i < n;i++) {//map 만들기
			String [] inp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}
		for(int i = 0; i < m; i++) {//공의 위치 지정
			String [] inp = br.readLine().split(" ");
			int x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
			ballMap[x-1][y-1] = true;
		}
		
		
		for(int i = 0; i < t; i++) {
			boolean [][] newBallMap = new boolean[n][n];//갱신된 공의 위치
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(ballMap[j][k]) {
						int max = 0;
						if(j!=0)max=Math.max(map[j-1][k], max);
						if(j!=n-1)max=Math.max(map[j+1][k], max);
						if(k!=0)max=Math.max(map[j][k-1], max);
						if(k!=n-1)max=Math.max(map[j][k+1], max);//최댓값 확인 후 상하좌우 순서로
						
						if(map[j][k]>max) {
							if(newBallMap[j][k])newBallMap[j][k]=false;
							else newBallMap[j][k] = true;
						}
						
						else if(j!=0 && map[j-1][k]==max) {
							if(newBallMap[j-1][k])newBallMap[j-1][k]=false;
							else newBallMap[j-1][k] = true;
						}
						else if (j!=n-1 && map[j+1][k]==max) {
							if(newBallMap[j+1][k])newBallMap[j+1][k]=false;
							else newBallMap[j+1][k] = true;
						}
						else if(k!=0 && map[j][k-1]==max) {
							if(newBallMap[j][k-1])newBallMap[j][k-1]=false;
							else newBallMap[j][k-1] = true;
						}
						else if(k!=n-1 && map[j][k+1]==max) {
							if(newBallMap[j][k+1])newBallMap[j][k+1]=false;
							else newBallMap[j][k+1] = true;
						}
						
					}
					
					
					
				}
			}
			
			ballMap = newBallMap;
			
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(ballMap[i][j])count++;
			}
		}
		System.out.println(count);
		
		
	}

	
	
}
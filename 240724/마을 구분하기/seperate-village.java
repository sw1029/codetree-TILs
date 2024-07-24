import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		map = new boolean[n+2][n+2];
		trv = new boolean[n+2][n+2];
		
		for(int i = 1; i <= n; i++) {
			String [] inp = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				if(inp[j-1].equals("1"))map[i][j] = true;
			}
		}
		int bCount = 0;
		ArrayList<Integer> person = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j]&&!trv[i][j]) {
					trv[i][j] = true;
					person.add(DFS(i,j));
					bCount++;
				}
				
			}
		}
		System.out.println(bCount);
		Collections.sort(person);
        
		for(int i = 0; i < person.size();i++) {
			System.out.println(person.get(i));
		}
        
    }
	static boolean [][] map, trv;
	
	static int DFS(int x, int y) {
		int [] dx = {-1,0,1,0};
		int [] dy = {0,-1,0,1};
		int sum = 1;
		Stack <Integer>sx = new Stack<>(),sy = new Stack<>();
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(map[nx][ny] && !trv[nx][ny]) {
				trv[nx][ny] = true;
				sum += DFS(nx,ny);
			}
		}
		
		return sum;
	}
	
	
}
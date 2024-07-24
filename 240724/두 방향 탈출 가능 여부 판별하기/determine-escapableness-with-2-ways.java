import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
        map = new boolean[n+2][m+2];
        trv = new boolean[n+2][m+2];
        
        for(int i = 1; i <= n; i++) {
        	String [] inp = br.readLine().split(" ");
        	for(int j = 0; j < m; j++) {
        		if(inp[j].equals("1"))map[i][j+1] = true;
        	}
        }
        Stack<Integer> stX = new Stack<>(), stY = new Stack<>();
        int nx=1,ny=1;
        int [] dx = {1,0};
        int [] dy = {0,1};
        stX.add(nx);
        stY.add(ny);
        trv[nx][ny] = true;
        while(!stX.isEmpty() && !stY.isEmpty()) {
        	nx = stX.pop();
        	ny = stY.pop();
        	if(nx == n && ny == m) {
        		System.out.println(1);
        		return;
        	}
        	for(int i = 0; i < 2; i++) {
        		if(map[dx[i]+nx][dy[i]+ny] && !trv[dx[i]+nx][dy[i]+ny]) {
        			trv[dx[i]+nx][dy[i]+ny] = true;
        			stX.add(dx[i]+nx);
        			stY.add(dy[i]+ny);
        		}
        	}
        	
        }
        System.out.println(0);
        
    }
	static boolean [] [] map;
	static boolean [] [] trv;
}
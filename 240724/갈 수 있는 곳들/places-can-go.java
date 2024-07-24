import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]),k=Integer.parseInt(input[1]);
        
        map = new boolean[n+2][n+2];
        trv = new boolean[n+2][n+2];
        
        for(int i = 1; i <= n; i++) {
        	String[]inp = br.readLine().split(" ");
        	for(int j = 0; j < n; j++) {
        		if(inp[j].equals("0"))map[i][j+1] = true;
        	}
        }
        
        
        int [] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        
        for(int i = 0; i < k; i++) {
        	Queue<Integer> qx = new LinkedList<>(), qy = new LinkedList<>();
        	String [] inp = br.readLine().split(" ");
        	qx.add(Integer.parseInt(inp[0]));
        	qy.add(Integer.parseInt(inp[1]));
        	
        	while(!qx.isEmpty() && !qy.isEmpty()) {
        		int nx = qx.poll(), ny = qy.poll();
        		
        		if(!trv[nx][ny])trv[nx][ny] = true;
        		for(int j = 0; j < 4; j++) {
        			int nnx = dx[j] + nx, nny = dy[j] + ny;
        			if(map[nnx][nny] && !trv[nnx][nny]) {
        				qx.add(nnx);
        				qy.add(nny);
        				trv[nnx][nny] = true;
        			}
        		}
        		
        	}
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <=n; j++) {
        		if(trv[i][j])count++;
        		
        	}
        	
        }
        System.out.println(count);
        
        
    }
	static boolean [] [] map;
	static boolean [] [] trv;
}
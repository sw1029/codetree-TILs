import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
        map = new boolean[n][m];
        trv = new boolean[n][m];
        for(int i = 0; i < n; i++) {
        	String [] inp = br.readLine().split(" ");
        	for(int j = 0; j < m; j++) {
        		if(inp[j].equals("1"))map[i][j] = true;
        	}
        }
        
        Queue <block> qu = new LinkedList<>();
        qu.add(new block(0,0));
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        trv[0][0] = true;
        while(!qu.isEmpty()) {
        	block now = qu.poll();
        	
        	for(int i = 0; i < 4; i ++) {
        		int nx = now.x + dx[i];
        		int ny = now.y + dy[i];
        		if(nx>=0&&ny>=0 && nx< n && ny <m && map[nx][ny] && !trv[nx][ny]) {
        			trv[nx][ny] = true;
					qu.add(new block(nx,ny));
        		}
					
        			
        	}
        }
        int answer = 0;
        if(trv[n-1][m-1])answer = 1;
        System.out.println(answer);
    }
	static boolean [] [] map;
	static boolean [] [] trv;
}
class block{
	int x,y;
	public block(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
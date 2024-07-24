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
        int answer = -1;
        Queue <block> qu = new LinkedList<>();
        qu.add(new block(0,0,0));
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        trv[0][0] = true;
        
        while(!qu.isEmpty()) {
        	block now = qu.poll();
        	if(now.x == n-1 && now.y == m-1)answer = now.len;
        	for(int i = 0; i < 4; i ++) {
        		int nx = now.x + dx[i];
        		int ny = now.y + dy[i];
        		if(nx>=0&&ny>=0 && nx< n && ny <m && map[nx][ny] && !trv[nx][ny]) {
        			qu.add(new block(nx,ny,now.len+1));
        			trv[nx][ny] = true;
        		}
        	}
        }
        System.out.println(answer);
    }
	static boolean [] [] map;
	static boolean [] [] trv;
}
class block{
	int x,y,len;
	public block(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public block(int x, int y, int len) {
		this.x = x;
		this.y = y;
		this.len = len;
	}
}
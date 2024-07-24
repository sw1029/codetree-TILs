import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
        
       
        boolean [][] trv = new boolean[n+4][n+4];
        int [][] map = new int[n+4][n+4];
        for(int i = 0; i < n+4; i++) {
        	for(int j = 0; j < n+4; j++) {
        		if(i<2 || i >n+1 ||j<2 || j>n+1) {
        			trv[i][j] = true;
        		}
        	}
        }
        
        String [] inp = br.readLine().split(" ");
        int r1 = Integer.parseInt(inp[0]), c1 = Integer.parseInt(inp[1]);
        int r2 = Integer.parseInt(inp[2]), c2 = Integer.parseInt(inp[3]);
        
        Queue<Integer>qr = new LinkedList<>(),qc = new LinkedList<>();
        
        qr.add(r1+1);
        qc.add(c1+1);
        trv[r1+1][c1+1] = true;
        map[r1+1][c1+1] = 0;
        
        int [] dx = {-2,-2,-1,-1, 1,1, 2,2};
        int [] dy = {-1, 1,-2, 2,-2,2,-1,1};
        
        while(!qr.isEmpty() && ! qc.isEmpty()) {
        	
        	int nr = qr.poll();
        	int nc = qc.poll();
        	
        	if(nr == r2+1 && nc == c2+1) {
        		System.out.println(map[nr][nc]);
        		return;
        	}
        	
        	for(int i = 0; i < 8; i++) {
        		int nnr = dx[i] + nr;
        		int nnc = dy[i] + nc;
        		
        		if(!trv[nnr][nnc]) {
        			trv[nnr][nnc] = true;
        			map[nnr][nnc] = map[nr][nc]+1;
        			qr.add(nnr);
        			qc.add(nnc);
        		}
        	}
        }
        
        System.out.println(-1);
        
    }
	
	
}
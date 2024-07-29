import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [2];
        counts = new long[Math.max(n+1, 4)];
        trv = new boolean[Math.max(n+1, 4)];
        trv[0] = true;
        trv[1] = true;
        trv[2] = true;
        trv[3] = true;
        counts[2] = 1;
        counts[3] = 1;
        
        System.out.println(stairs(n)%10007);
    }
	static long [] counts;
	static boolean [] trv;
	
	static long stairs(int n) {
		if(!trv[n]) {
			counts[n] = Math.min(stairs(n-2), stairs(n-3)) + 1;
			trv[n] = true;
		}
		return counts[n];
	}
	
}
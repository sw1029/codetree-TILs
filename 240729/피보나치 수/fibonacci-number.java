import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		System.out.println(pibo(n));
        
    }
	
	static int pibo(int n) {
		if(n <= 2)return 1;
		
		return pibo(n-2) + pibo(n-1);
	}
	
	
}
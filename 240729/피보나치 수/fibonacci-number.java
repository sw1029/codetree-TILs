import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int sum = 2;
        pibos.add(1);
        pibos.add(1);
        for(int i = 0; i < n-2; i++) {
        	pibos.add(sum);
        	sum += pibos.get(pibos.size()-2);
        }
		
		System.out.println(pibos.get(n-1));
        
    }
	static ArrayList<Integer>pibos = new ArrayList<>();
	
	
	
}
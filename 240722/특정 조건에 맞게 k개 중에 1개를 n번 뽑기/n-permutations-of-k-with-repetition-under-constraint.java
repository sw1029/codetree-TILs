import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(), n = scan.nextInt();
        
        arr = new String[(int)Math.pow(k, n)];
        
        num(k,n,0,"",1,false);
        for(int i = 0; i < arr.length; i++) {
        	if(!Objects.isNull(arr[i]))System.out.println(arr[i]);
        }
    }
	static int count = 0;
	static String[] arr;
    static void num(int k, int n, int c, String st, int bc,boolean isf){
        if(c == n) {
        	if(!isf)arr[count] = st;
        	count+=1;
        	return;
        }
        for(int i = 1; i <= k; i++) {
        	if(st.length()>0 && st.split(" ")[c-1].equals(i+"")) {
        		bc+=1;
        		if(bc>2)isf = true;
        		num(k,n,c+1,st + i+ " ",bc+1,isf);
        	}
        	else num(k,n,c+1,st + i+ " ",1,isf);
        	
        	
        }
    	
    }

	
	
}
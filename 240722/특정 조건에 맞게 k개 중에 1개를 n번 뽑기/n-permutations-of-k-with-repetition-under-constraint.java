import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(), n = scan.nextInt();
        
        arr = new String[(int)Math.pow(k, n)];
        
        num(k,n,0,"",0);
        for(int i = 0; i < arr.length; i++) {
        	if(!Objects.isNull(arr[i]))System.out.println(arr[i]);
        }
    }
	static int count = 0;
	static String[] arr;
    static void num(int k, int n, int c, String st, int bc){
        if(c == n) {
        	if(bc < 2)arr[count] = st;
        	else arr[count] = null;
        	count+=1;
        	return;
        }
        for(int i = 1; i <= k; i++) {
        	if(st.length()>0 && st.split(" ")[c-1].equals(i+""))num(k,n,c+1,st + i+ " ",bc+1);
        	else num(k,n,c+1,st + i+ " ",bc);
        }
    	
    }

	
}
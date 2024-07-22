import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();

        for(int i = 1; i <= n;i++){
            num(i,m);
        }
    }
    static void num(int n, int m){
        for(int i = 1; i <= m; i++){
            System.out.println(n + " " + i);
        }
    }
}
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] nextGrid = new int[MAX_N][MAX_N];
    
    public static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) && 
               Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange;
    }
    
    public static void bomb(int centerX, int centerY) {
        int bombRange = grid[centerX][centerY];
        
        // Step1. 폭탄이 터질 위치는 0으로 채워줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(inBombRange(i, j, centerX, centerY, bombRange))
                    grid[i][j] = 0;
        
        // Step2. 폭탄이 터진 이후의 결과를 nextGrid에 저장합니다.
        for(int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for(int i = n - 1; i >= 0; i--) {
                if(grid[i][j] > 0)
                    nextGrid[nextRow--][j] = grid[i][j];
            }
        }
        
        // Step3. grid로 다시 값을 옮겨줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = nextGrid[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        bomb(r - 1, c - 1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}
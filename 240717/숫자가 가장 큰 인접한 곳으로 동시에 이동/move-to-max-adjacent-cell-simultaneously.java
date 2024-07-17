import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        int[][] map = new int[n][n];
        boolean[][] ballMap = new boolean[n][n];

        // Initialize map
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // Initialize ballMap
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            ballMap[x][y] = true;
        }

        // Process ball movements
        for (int step = 0; step < t; step++) {
            boolean[][] newBallMap = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ballMap[i][j]) {
                        int max = map[i][j];
                        int newX = i, newY = j;

                        if (i > 0 && map[i - 1][j] > max) {
                            max = map[i - 1][j];
                            newX = i - 1;
                            newY = j;
                        }
                        if (i < n - 1 && map[i + 1][j] > max) {
                            max = map[i + 1][j];
                            newX = i + 1;
                            newY = j;
                        }
                        if (j > 0 && map[i][j - 1] > max) {
                            max = map[i][j - 1];
                            newX = i;
                            newY = j - 1;
                        }
                        if (j < n - 1 && map[i][j + 1] > max) {
                            max = map[i][j + 1];
                            newX = i;
                            newY = j + 1;
                        }

                        newBallMap[newX][newY] = !newBallMap[newX][newY];
                    }
                }
            }

            ballMap = newBallMap;
        }

        // Count the balls
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballMap[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
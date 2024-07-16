import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        //int m = Integer.parseInt(inp[1]);
        String[][] block = new String[n][n];

        for (int i = 0; i < n; i++) {
            block[i] = br.readLine().split(" ");
        }

        int max = 0;

        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                String[] nums = block[i];
                for (int j = 0; j < n; j++) {
                    if (nums[j].equals("1")) {
                        max += 1;
                    }
                }
            }
            System.out.print(max);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            String[] bnums = block[i - 1];
            String[] nums = block[i];
            String[] anums = block[i + 1];

            for (int j = 1; j < n - 1; j++) {
                int sum = 0;
                if (nums[j - 1].equals("1")) sum += 1;
                if (nums[j + 1].equals("1")) sum += 1;
                if (anums[j].equals("1")) sum += 1;
                if (bnums[j].equals("1")) sum += 1;
                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}
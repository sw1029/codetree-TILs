import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), max = 0;
        String [] block = new String[n];
        for(int i = 0; i < 3; i++)block[i]=br.readLine();
        if(n<=3){
            for(int i = 0; i < n; i++){
                String[] nums = block[i].split(" ");
                for(int j = 0; j < n; j++)if(nums[j].equals("1"))max+=1;
            }
            System.out.print(max);
            return;
        }
        for(int i = 1; i < n-1;i++){
            String[] bnums = block[i-1].split(" ");
            String[] nums = block[i].split(" ");
            String[] anums = block[i+1].split(" ");
            for(int j = 1; j < n-1; j++){
                int sum = 0;
                if(nums[j-1].equals("1"))sum+=1;
                if(nums[j+1].equals("1"))sum+=1;
                if(anums[j].equals("1"))sum+=1;
                if(bnums[j].equals("1"))sum+=1;
                max = Math.max(max,sum);
            }
        }
        System.out.print(max);
    }
}
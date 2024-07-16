import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] numbers = new int[MAX_N];

    public static int endOfArray;

    // 입력 배열에서 지우고자 하는 부분 수열을 삭제합니다.
    public static void cutArray(int startIdx, int endIdx) {
        int[] tempArr = new int[MAX_N];
        int endOfTempArray = 0;
        
        // 구간 외의 부분만 temp 배열에 순서대로 저장합니다.
        for(int i = 0; i < endOfArray; i++)
            if(i < startIdx || i > endIdx)
                tempArr[endOfTempArray++] = numbers[i];
        
        // temp 배열을 다시 numbers 배열로 옮겨줍니다.
        for(int i = 0; i < endOfTempArray; i++)
            numbers[i] = tempArr[i];
        
        endOfArray = endOfTempArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();
        
        endOfArray = n;
	
        // 두 번에 걸쳐 지우는 과정을 반복합니다.
        for(int k = 0; k < 2; k++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            s--; e--;
            // [s, e] 구간을 삭제합니다.
            cutArray(s, e);
        }
        
        // 출력:
        System.out.println(endOfArray);
        for(int i = 0; i < endOfArray; i++)
            System.out.println(numbers[i]);
    }
}
package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2018 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 몇 개의 연속된 자연수의 합으로 나타 낼 수 있다.
        int answer = 0; // 가지수

        int[] nums = new int[N];
        for(int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }

        if (N > 1) { // N이 1인 경우 아래 로직에서 Array 범위를 벗어난다.
            int start = 0;
            int end = 1;
            int sum = nums[start] + nums[end];
            while (end < N-1){
                if(sum == N) {
                    answer++;
                    sum = sum - nums[start++] + nums[++end];
                }else if(sum > N) {
                    sum = sum - nums[start++];
                }else if(sum < N) {
                    sum = sum + nums[++end];
                }
            }
        }

        System.out.println(answer + 1);
    }

}

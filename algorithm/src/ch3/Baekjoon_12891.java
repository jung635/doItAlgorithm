package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1253 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 개의 수
        long nums[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        int answer = 0; // 만들 수 있는 갑옷의 수


        for(int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            long M = nums[i];
            long sum = 0;
            while (start < end){
                sum = nums[start] + nums[end];
                if(sum == M) {
                    if(i == start) start++;
                    else if(i == end) end--;
                    else {
                        answer++;
                        break;
                    }
                }else if(sum > M) {
                    end--;
                }else if(sum < M) {
                    start++;
                }
            }
        }


        System.out.println(answer);

    }

}

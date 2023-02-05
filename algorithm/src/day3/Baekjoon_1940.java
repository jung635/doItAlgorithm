package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1940 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
        String[] numStrs = br.readLine().split(" ");
        int[] nums = Arrays.asList(numStrs).stream().mapToInt(Integer::parseInt).sorted().toArray();
        int answer = 0; // 만들 수 있는 갑옷의 수

        int start = 0;
        int end = N - 1;
        while (start < end){
            if(nums[start] + nums[end] == M) {
                answer++;
                start++;
                end--;
            }else if(nums[start] + nums[end] > M) {
                end--;
            }else if(nums[start] + nums[end] < M) {
                start++;
            }
        }

        System.out.println(answer);

    }

}

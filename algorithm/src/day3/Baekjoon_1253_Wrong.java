package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//틀린 케이스: 정수 0을 포함한 경우 (ex. 0 1 1)
public class Baekjoon_1253_Wrong {
    
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


        if(N > 2) {
            //M 이후숫자와 M이하 숫자를 더하면 M을 만들수 없다 생각하여,M이하 배열만 두 포인터 방식으로 계산하려했으나, 예외 케이스 존재 (ex. 0 1 1)
            for(int i = 2; i < N; i++) {
                int start = 0;
                int end = i-1;
                long M = nums[i];
                while (start < end){
                    if(nums[start] + nums[end] == M) {
                        answer ++;
                        break;
                    }else if(nums[start] + nums[end] > M) {
                        start++;
                    }else if(nums[start] + nums[end] < M) {
                        end--;
                    }
                }
            }
        }

        System.out.println(answer);

    }

}

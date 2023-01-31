package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]); // M으로 나누어 떨어지는 (i,j) 쌍의 개수 구하기
        long result = 0;

        // 나머지 합 배열 만들기 START
        long[] sum = new long[N]; // 합 배열 (**** long으로 해주지 않으면 런타임 에러(ArrayIndexOutOfBounds) 발생)
        long[] rests = new long[M]; // 나머지 배열
        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < N ; i++) {
            if(i == 0) sum[i] = Long.parseLong(numbers[i]);
            else sum[i] = sum[i-1] + Long.parseLong(numbers[i]);
            int rest = (int)(sum[i]%M);
            if(rest == 0) result++; //나머지 0인것 카운트
            rests[rest]++; //각 나머지가 동일한 개수 증가
        }

        // (rests[i] - rests[j]) % M 각각 M으로 나누어 떨어지는 것과 같다.
        // rests[i] - rests[j]는 j+1 ~ i까지 구간 합
        // rests[i], rests[j]가 같다면 j+1 ~ i까지 구간 합이 M으로 나누어 떨어진다.
        // 따라서 구간합 나머지(rests)에서 같은 값 두개를 고르는 경우의수를 더해야한다.
        for(int i = 0; i < M ; i++) {
            result = result + rests[i] * (rests[i] - 1) / 2;
        }

        System.out.println(result);


    }
}
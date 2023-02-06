package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N개
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int sum = 0;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            sum += array[i];
            answer += sum;
            //System.out.println(sum);
        }
        System.out.println(answer);
    }
}

package day7;

import java.io.*;
import java.util.StringTokenizer;
//기수정렬
public class Baekjoon_10989 {
    static int[] array;
    static int N;
    static int max_digits = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        radix_sort();
        for(int i = 0; i < N; i++) {
            bw.write(array[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void radix_sort() {
        int digit = 1;
        int cnt = 0;
        int output[] = new int[N];
        while(cnt <= max_digits) {
            int[] bucket = new int[10];
            for(int i = 0; i < N; i++) {
                bucket[(array[i]/digit) % 10]++;
            }
            //합 배열을 이용한 index 계산
            for(int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for(int i = array.length - 1; i >=0; i--) {
                output[bucket[(array[i]/digit) % 10] - 1] = array[i];
                bucket[(array[i]/digit) % 10]--;
            }

            for(int i = 0; i < N; i++) {
                array[i] = output[i];
            }

            digit *= 10;
            cnt ++;
        }
    }
}

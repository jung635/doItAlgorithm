package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1427 {
    //선택정렬 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("");
        int[] array = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

       for(int i = 0; i < array.length; i++) {
            int max = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[max] < array[j]) {
                    max = j;
                }
            }

            if(max != i) {
                int tmp = array[max];
                array[max] = array[i];
                array[i] = tmp;
            }
        }

       for(int n : array) {
           System.out.print(n);
       }
    }
}

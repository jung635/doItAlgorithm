package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] inputs = br.readLine().toCharArray();
        int result = 0;
        for(char input : inputs) {
            result += input - '0'; //'0' ASCII:48, '1' ASCII: 49
        }

        System.out.println(result);
    }
}
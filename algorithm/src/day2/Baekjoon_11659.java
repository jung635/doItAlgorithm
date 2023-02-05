package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numCount = Integer.parseInt(input[0]);
        int playCount = Integer.parseInt(input[1]);

        String[] targets = br.readLine().split(" ");
        int targetNum = 0;
        long[] S = new long[numCount + 1];
        for(int i = 1; i <= numCount; i++) {
            targetNum = Integer.parseInt(targets[i - 1]);
            S[i] = S[i -1] + targetNum;
        }

        int play = 0;
        while(play < playCount) {
            String[] range = br.readLine().split(" ");
            int startIndex = Integer.parseInt(range[0]);
            int endIndex = Integer.parseInt(range[1]);
            play ++;
            System.out.println(S[endIndex] - S[startIndex - 1]);
        }
    }
}
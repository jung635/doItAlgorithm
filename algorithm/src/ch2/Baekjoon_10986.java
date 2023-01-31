package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tableCount = Integer.parseInt(input[0]);
        int playCount = Integer.parseInt(input[1]);

        // 합 배열 만들기 START
        // 0,0에서 시작하여 각 지점(value) 까지 합 (value = sum(x-1, y) + sum(x, y-1) - sum(x-1, y-1) + value)
        int[][] sum = new int[tableCount + 1][tableCount + 1]; // 합배열
        for(int i = 1; i <= tableCount; i++) {
            int sumIndex = 1;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens()) {
                int num = Integer.parseInt(stk.nextToken());
                sum[i][sumIndex] = sum[i-1][sumIndex] + sum[i][sumIndex - 1] - sum[i - 1][sumIndex - 1] + num;
                sumIndex ++;
            }
        }

        // 합 계산
        // sum(x2, y2) - sum(x1-1, y2) - sum(x2, y1-1) + sum(x1-1, y1-1)
        for(int i = 0; i < playCount; i++) {
            String[] range = br.readLine().split(" ");
            int x1 = Integer.parseInt(range[0]);
            int y1 = Integer.parseInt(range[1]);
            int x2 = Integer.parseInt(range[2]);
            int y2 = Integer.parseInt(range[3]);

            System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
        }
    }
}
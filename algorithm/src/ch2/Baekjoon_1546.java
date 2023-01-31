package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        double[] scores = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sorted().toArray();
        double maxScore = scores[scores.length-1];
        double fakeScoreSum = 0;
        for(double score : scores) {
            //조작점수 = 실제점수/최고점*100
            fakeScoreSum += score/maxScore*100;
        }
        System.out.println(fakeScoreSum/scores.length);
    }
}
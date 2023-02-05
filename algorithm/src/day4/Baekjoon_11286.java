package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N번 연산

        PriorityQueue<Integer> q = new PriorityQueue<>(((o1, o2) -> {
            int result = Math.abs(o1) - Math.abs(o2);
            if(result == 0) result = o1 - o2;
            return result;
        }));
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input != 0) q.add(input);
            else if(q.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(q.poll());
            }
        }
    }
}

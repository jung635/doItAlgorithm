package day3;

import java.io.*;
import java.util.*;

public class Baekjoon_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //N개의 개수
        int L = Integer.parseInt(input[1]); //범위
        //result Node(index, value) firstIndex i-L
        // 1 => 1 0 -3
        // 1 5 => 1 0 -2
        // 1 2 => 1 0 -1
        // 2 3 => 2 0 0
        // 2 3 6 => 2 2 1
        // 2 => 2 2 2
        // 2 3 => 2 5 3
        // 2 3 7 => 2 5 4
        // 3 3 => 3 5 5
        // 3 5 => 3 6 6
        // 2 => 2 8 7
        // 2 => 2 8 8
        StringTokenizer st = new StringTokenizer(br.readLine()); //1 5 2 3 6 2 3 7 3 5 2 6
        Deque<Node> dq = new LinkedList();
        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && now < dq.getLast().value) dq.removeLast();
            Node node = new Node(i, now);
            dq.addLast(node);

            if(dq.getFirst().index == i - L) {
                dq.removeFirst();
            }

            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

}



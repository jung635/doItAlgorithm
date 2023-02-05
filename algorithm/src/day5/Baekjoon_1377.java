package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Number[] array = new Number[N];
        for(int i = 0; i < N; i++) {
            array[i] = new Number(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(array);

        int maxMove = 0;
        for(int i = 0; i < N; i++) {
            int move = array[i].index - i; //왼쪽으로는 한칸씩만 이동하고, 가장 많이 이동한 수가 최종 이동 수
            if(move > maxMove) maxMove = move;
        }

        System.out.println(maxMove + 1); //swap이 일어나지 않는 경우의 수 +1
    }
}

class Number implements Comparable<Number> {
    int index;
    int value;

    public Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}

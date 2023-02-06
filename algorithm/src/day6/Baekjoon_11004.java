package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11004 {
    //퀵소트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // N개
        int K = Integer.parseInt(input[1]); // K번째
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(array, 0, array.length - 1);
        //퀵 소트 시작
        System.out.println(array[K-1]);
    }

    private static int[] quickSort(int[] array, int startIndex, int endIndex) {
        int tmpStartIndex = startIndex;
        int tmpEndIndex = endIndex;
        int pivot = array[(endIndex+startIndex)/2];

        while(startIndex <= endIndex) { //=을 포함해주는 이유는, 이미 정렬이 되어있어 변화가 없을때, 해당 인덱스에 변화가 없으면 두번째 quickSort가 무한루프 돌게된다.
            if(array[startIndex] >= pivot && array[endIndex] <= pivot) {
                swap(array, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }else if(array[startIndex] < pivot) {
                startIndex ++;
            }else if(array[endIndex] > pivot) {
                endIndex --;
            }
        }
        if(tmpStartIndex < startIndex - 1) quickSort(array, tmpStartIndex, startIndex-1);
        if(tmpEndIndex > startIndex) quickSort(array, startIndex, tmpEndIndex);

        return array;
    }

    private static void swap(int[] array, int startIndex, int endIndex) {
        int tmp =  array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        startIndex ++;
        endIndex --;
    }
}

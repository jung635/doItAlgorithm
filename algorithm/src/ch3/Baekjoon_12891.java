package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_12891 {
    static final String[] DNA_MAND_STR = {"A", "C", "G", "T"};
    static int[] CUR_Count = new int[DNA_MAND_STR.length];
    static int CUR_COUNT_CHECK = 0;

    public static int[] MAND_COUNT = new int[DNA_MAND_STR.length]; // 포함되어야 할 ACGT 최소개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] SP = br.readLine().split(" ");
        int S = Integer.parseInt(SP[0]); // DNA 문자열의 길이
        int P = Integer.parseInt(SP[1]); // 비밀번호로 사용할 부분 문자열의 길이
        String[] DNA = br.readLine().split(""); //DNA 문자열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < DNA_MAND_STR.length; i++) {
            MAND_COUNT[i] = Integer.parseInt(st.nextToken());
            if(MAND_COUNT[i] == 0) CUR_COUNT_CHECK ++;
        }

        int answer = 0;
        for(int i = 0; i < P; i++) {
            move(DNA[i], 1);
        }
        if(CUR_COUNT_CHECK == DNA_MAND_STR.length) answer ++;

        //1. 이동 될 때, 양쪽 아이템을 Deque에서 추가, 삭제한다.
        //2. 추가, 삭제되는 아이템이 ACGT인지 체크하고, 개수를 조절한다.
        //3. 조절 된 개수가 포함되어야 할 ACGT 최소개수에 부합하는지 확인한다.
        for(int i = P; i < S; i++) {
            move(DNA[i], 1);
            move(DNA[i-P], -1);
            if(CUR_COUNT_CHECK == DNA_MAND_STR.length) answer ++;
        }
        System.out.println(answer);
        br.close();
    }

    private static void move(String item, int addCnt) {
        for(int i = 0; i < DNA_MAND_STR.length; i++) {
            if(DNA_MAND_STR[i].equals(item)) {
                if(addCnt > 0) {
                    CUR_Count[i] += addCnt;
                    if(CUR_Count[i] == MAND_COUNT[i]) CUR_COUNT_CHECK += addCnt;
                }else {
                    if(CUR_Count[i] == MAND_COUNT[i]) CUR_COUNT_CHECK += addCnt;
                    CUR_Count[i] += addCnt;
                }

                break;
            }

        }
    }

}

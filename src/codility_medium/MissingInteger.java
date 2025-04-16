package codility_medium;

import java.util.Arrays;

public class MissingInteger {
    //https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
    public int solution(int[] A) {
        int size = A.length;
        int chkNum = 1;
        Arrays.sort(A); //오름차순 정렬


        for (int i = 0; i < size; i++) {
            if (A[i] == chkNum) { //현재 기준 제일 작은 수 있으면 다음 작은 수 탐색
                chkNum++;
            }
        }

        return chkNum;
    }
}

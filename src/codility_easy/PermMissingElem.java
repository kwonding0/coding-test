package codility_easy;

import java.util.Arrays;

public class PermMissingElem {
    //https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
    public int solution(int[] A) {
        int answer = 1;

        if (A.length > 0) {
            //오름차순으로 정렬
            Arrays.sort(A);

            if (A[0] == 1) {
                //전 인덱스의 값과 1이상 차이나는걸 찾음
                for (int i = 0; i < A.length; i++) {
                    if (i == A.length - 1) { //마지막턴일때
                        answer = A[i] + 1;
                    } else {
                        if (A[i + 1] - A[i] > 1) {
                            answer = A[i + 1] - 1;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}

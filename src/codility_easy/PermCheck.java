package codility_easy;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {
    //https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
    public int solution(int[] A) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>(); //1~X까지 모든 숫자를 이음.
        for (int i = 1; i <= A.length; i++) {
            map.put(i, 1);
        }

        for (int i = 0; i < A.length; i++) {
            map.remove(A[i]);
        }

        if (map.size() == 0) { //순열
            answer = 1;
        }

        return answer;
    }
}

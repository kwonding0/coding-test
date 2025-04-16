package codility_easy;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {
    //https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
    public int solution(int X, int[] A) {
        int answer = -1;
        Map<Integer, Integer> frogLoad = new HashMap<>(); //1~X까지 모든 숫자를 이음.
        for (int i = 1; i <= X; i++) {
            frogLoad.put(i, 1);
        }

        for (int j = 0; j < A.length; j++) {
            frogLoad.remove(A[j]);
            if (frogLoad.size() == 0) {
                answer = j;
                break;
            }
        }

        return answer;
    }
}

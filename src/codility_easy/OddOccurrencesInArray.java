package codility_easy;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    //https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
    public int solution(int[] A) {
        int size = A.length;
        int answer = 0;
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int key = A[i];
            System.out.println("key = " + key);
            System.out.println("numCnt.containsKey(key) = " + numCnt.containsKey(key));

            if (!numCnt.containsKey(key)) {
                numCnt.put(key, 1);
            } else {
                int val = numCnt.get(key);
                numCnt.put(key, ++val);
                System.out.println("val = " + val);
                System.out.println("= = = = = = = = = = = = = = = = = = ");
            }
        }

        for (Map.Entry<Integer, Integer> entry : numCnt.entrySet()) {
            System.out.println("entry.getValue() = " + entry.getValue());
            System.out.println("entry.getKey() = " + entry.getKey());
            if (entry.getValue() % 2 == 1) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}

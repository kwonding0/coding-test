package codility_medium;

public class MaxCounter {
    public int[] solution(int N, int[] A) {
        //https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
        int[] counters = new int[N];
        int size = A.length;
        int maxCounter = 0;
        int sumMaxCounter = 0;

        for (int i = 0; i < size; i++) {
            if (N < A[i]) { //maxCounter걸리면 reset 처리 (maxCounter값은 나중에 합산)
                sumMaxCounter = maxCounter;
            } else {
                int counter = A[i] - 1;
                if (counters[counter] < sumMaxCounter) {
                    counters[counter] = sumMaxCounter + 1; //+1
                } else {
                    counters[counter]++; //+1
                }

                maxCounter = Math.max(maxCounter, counters[counter]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < sumMaxCounter) {
                counters[i] = sumMaxCounter;
            }
        }

        return counters;
    }
}

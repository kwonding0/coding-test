package codility_easy;

public class TapeEquilibrium {
    //https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
    public int solution(int[] A) {
        int min = 0;
        int underSum = 0;
        int upSum = 0;
        int totSum = 0;//Arrays.stream(A).sum();

        for (int i = 0; i < A.length; i++) {
            totSum += A[i];
        }

        for (int i = 0; i < A.length - 1; i++) {
            underSum += A[i];

            //큰수에서 작은수를 뺴야함.
            upSum = totSum - underSum;

            int diff = Math.abs(underSum - upSum);
            if (diff == 0) {
                min = diff;
                break;
            }
            min = i == 0 ? diff : Math.min(min, diff);
        }

        return min;
    }
}

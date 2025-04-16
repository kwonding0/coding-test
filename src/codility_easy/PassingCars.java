package codility_easy;

public class PassingCars {
    //https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
    public int solution(int[] A) {
        int answer = 0;
        int eastCnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) eastCnt++;
            else answer += eastCnt;

            if (answer > 1000000000) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

}

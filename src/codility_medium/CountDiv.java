package codility_medium;

public class CountDiv {
    //https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
    public int solution(int A, int B, int K) {
        int answer = 0;
        int minMod = A / K + (A % K != 0 ? 1 : 0);
        int maxMod = B / K;

        answer = maxMod - minMod + 1;
        return answer;
    }
}

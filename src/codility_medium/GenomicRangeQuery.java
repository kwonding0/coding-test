package codility_medium;

import java.util.Arrays;

public class GenomicRangeQuery {
    //https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
    public int[] solution(String S, int[] P, int[] Q) {
        int M = P.length;
        int N = S.length();
        int[] answer = new int[M];
        int[][] dna = new int[3][N];

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);

            //이전 값 복사
            if (i > 0) {
                dna[0][i] = dna[0][i - 1];
                dna[1][i] = dna[1][i - 1];
                dna[2][i] = dna[2][i - 1];
            }

            //+1
            if (c == 'A') dna[0][i]++;
            else if (c == 'C') dna[1][i]++;
            else if (c == 'G') dna[2][i]++;
        }

        int startIdx = 0;
        int lastIdx = 0;
        int A = 0;
        int C = 0;
        int G = 0;
        for (int i = 0; i < M; i++) {
            startIdx = P[i];
            lastIdx = Q[i];

            if (lastIdx == 0) {
                A = dna[0][0];
                C = dna[1][0];
                G = dna[2][0];
            } else if (lastIdx == startIdx) {
                A = dna[0][lastIdx] - dna[0][lastIdx - 1];
                C = dna[1][lastIdx] - dna[1][lastIdx - 1];
                G = dna[2][lastIdx] - dna[2][lastIdx - 1];
            } else {
                A = dna[0][lastIdx] - dna[0][startIdx];
                C = dna[1][lastIdx] - dna[1][startIdx];
                G = dna[2][lastIdx] - dna[2][startIdx];
            }

            if (A > 0) {
                answer[i] = 1;
            } else if (C > 0) {
                answer[i] = 2;
            } else if (G > 0) {
                answer[i] = 3;
            } else {
                answer[i] = 4;
            }
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}

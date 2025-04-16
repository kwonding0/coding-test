package level3;

import java.util.Arrays;

public class Immigration {
    // 입국심사
    // https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
    public long solution(int n, int[] times) {
        long start = 0;
        long end = (long) Arrays.stream(times).max().orElse(0) * n / times.length;
        long mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            long allTime = 0;
            for (int time : times) {
                allTime += mid / time;
                if (allTime > n) break;
            }

            if (allTime < n) {
                start++;
            } else {
                end = mid;
            }
        }

        return start;
    }
}


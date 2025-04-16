package level3;

import java.util.Arrays;

public class AddAdvertisement {
    // 광고삽입
    // https://school.programmers.co.kr/learn/courses/30/lessons/72414
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int pt = timeToNum(play_time);
        long[] timeLine = new long[pt + 1];

        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split("-");
            int startTime = timeToNum(log[0]);
            timeLine[startTime]++;
            int endTime = timeToNum(log[1]);
            timeLine[endTime]--;
        }

        //현재 동영상을 시청하고 있는 사람의 수 계산(누적합)
        for (int i = 1; i < timeLine.length; i++) {
            timeLine[i] += timeLine[i - 1];
        }

        //현재 시간까지 동영상을 시청한 총 재생시간 계산(누적합)
        for (int i = 1; i < timeLine.length; i++) {
            timeLine[i] += timeLine[i - 1];
        }

        //광고시간이 20분이라고 생각한다면,
        //10분~30분사이에 누적시청시간을 알고싶다면,  우리가 구한 누적합을사용한다. 누적합 30 - 누적합 10
        int at = timeToNum(adv_time);
        long max = timeLine[at - 1];
        int current = 0;
        for (int i = 0; i + at <= pt; i++) {
            long sum = timeLine[i + at] - timeLine[i];
            if (max < sum) {
                max = sum;
                current = i + 1;
            }
        }

        answer = numToTime(current);
        return answer;
    }

    private int timeToNum(String s) {
        int time = 0;
        Integer[] i = Arrays.stream(s.split(":")).map(Integer::valueOf).toArray(Integer[]::new);
        time = i[0] * 3600 + i[1] * 60 + i[2];
        return time;
    }

    private String numToTime(int time) {
        int H = time / 3600;
        int M = (time - 3600 * H) / 60;
        int S = time - 3600 * H - 60 * M;

        return (H < 10 ? "0" : "") + H + ":" +
                (M < 10 ? "0" : "") + M + ":" +
                (S < 10 ? "0" : "") + S;
    }
}


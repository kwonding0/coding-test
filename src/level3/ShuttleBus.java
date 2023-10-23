package level3;

import java.time.LocalTime;
import java.util.Arrays;

public class ShuttleBus {
    // 셔틀버스
    // https://school.programmers.co.kr/learn/courses/30/lessons/17678


    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String[] shuttleTime = new String[n];
        LocalTime startTime = LocalTime.of(9, 0);
        shuttleTime[0] = startTime.toString();

        //크루원 도착시간 정렬
        timetable = Arrays.stream(timetable).sorted().toArray(String[]::new);

        //셔틀 도착 시간 배열 구하기
        for (int i = 1; i < n; i++) {
            startTime = startTime.plusMinutes(t);
            shuttleTime[i] = startTime.toString();
        }

        int j = 0;
        int cnt = 0;
        boolean reset = false;
        Integer[] shuttleHm = Arrays.stream(shuttleTime[j].split(":")).map(Integer::valueOf).toArray(Integer[]::new);
        LocalTime lhm1 = LocalTime.of(shuttleHm[0], shuttleHm[1]);
        for (int i = 0; i < timetable.length; i++) {
            String time = timetable[i];
            Integer[] hm = Arrays.stream(time.split(":")).map(Integer::valueOf).toArray(Integer[]::new);
            System.out.println("hm = " + Arrays.toString(hm));
            LocalTime lhm2 = LocalTime.of(hm[0], hm[1]);
            if (!lhm2.isAfter(lhm1)) {
                cnt++;
                if (cnt == m || i == timetable.length - 1) {
                    reset = true;
                }
            } else {
                reset = true;
                i--;
            }

            if (reset) {
                if (j == n - 1) { //마지막 셔틀시간에 마지막으로 탑승한 사람의 시간 확인
                    if (cnt == m) { //셔틀버스에 사람이 꽉찼으면 마지막 탑승 사람보다 1분 빠르게 도착해야함
                        answer = LocalTime.of(hm[0], hm[1]).plusMinutes(-1).toString();
                    } else { //셔틀버스에 자리가 남았으면 마지막 셔틀시간에 도착하면됨
                        answer = shuttleTime[j];
                    }
                    break;
                }
                reset = false;
                cnt = 0;
                shuttleHm = Arrays.stream(shuttleTime[++j].split(":")).map(Integer::valueOf).toArray(Integer[]::new);
                lhm1 = LocalTime.of(shuttleHm[0], shuttleHm[1]);
            }

        }

        return answer;
    }


}


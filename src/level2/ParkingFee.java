package level2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingFee {

    //주차 요금 계산
    //https://school.programmers.co.kr/learn/courses/30/lessons/92341
    int basicTime; //기본 시간(분)
    int basicFee; //기본 요금(원)
    int partTime; //단위 시간(분)
    int partFee; //단위 요금(원)

    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0]; //기본 시간(분)
        basicFee = fees[1]; //기본 요금(원)
        partTime = fees[2]; //단위 시간(분)
        partFee = fees[3]; //단위 요금(원)
        Map<String, String> enterRecord = new HashMap<String, String>();
        Map<String, Double> timeRecord = new TreeMap<String, Double>(); //key값이 오름차순으로 저장되기 위한 TreeMap

        for (String record : records) {
            /*
             * 아이디별 닉네임을 nickName map에 관리
             * split[0] : 입출차 시각
             * split[1] : 차랑번호
             * split[2] : IN / OUT
             */
            String[] split = record.split(" ");
            if (split[2].equals("IN")) {
                enterRecord.put(split[1], split[0]);
            } else {
                //총 주차 시간 계산
                LocalTime localTime1 = LocalTime.parse(enterRecord.get(split[1])); //입차 시각
                LocalTime localTime2 = LocalTime.parse(split[0]); //출차 시각
                Duration duration = Duration.between(localTime1, localTime2);
                long parkingTime = duration.toHours() * 60 + duration.toMinutes() % 60;

                //누적 주차시간 저장
                timeRecord.merge(split[1], (double) parkingTime, (k, v) -> timeRecord.get(split[1]) + (double) parkingTime);
                enterRecord.remove(split[1]);
            }
        }

        //출차시각이 없는 차량은 출차시각을 23:59분으로 계산하여 누적시간에 더하기
        if (enterRecord.size() > 0) {
            //총 주차 시간 계산
            for (Map.Entry<String, String> entry : enterRecord.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                //총 주차 시간 계산
                LocalTime localTime1 = LocalTime.parse(value); //입차 시각
                LocalTime localTime2 = LocalTime.parse("23:59"); //출차 시각
                Duration duration = Duration.between(localTime1, localTime2);
                long parkingTime = duration.toHours() * 60 + duration.toMinutes() % 60;

                //누적 주차시간 저장
                double time = timeRecord.get(key) == null ? (double) parkingTime : timeRecord.get(key);
                timeRecord.merge(key, time, (k, v) -> time + (double) parkingTime);
            }
        }

        int i = 0;
        int[] answer = new int[timeRecord.size()];
        for (Map.Entry<String, Double> entry : timeRecord.entrySet()) { //모든 차량 누적시간 기준으로 주차요금 계산
            answer[i] = calFee(entry.getValue());
            i++;
        }

        return answer;
    }

    private int calFee(double parkingTime) { //주차요금 계산 함수
        double parkingFee = 0;
        if (basicTime >= parkingTime) {
            parkingFee = basicFee;
        } else {
            parkingFee = basicFee + Math.ceil((parkingTime - basicTime) / partTime) * partFee; //단위요금 계산은 단위시간 올림해서
        }

        return (int) parkingFee;
    }
}

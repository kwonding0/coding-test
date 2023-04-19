package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FailRate {

    //실패율
    //https://school.programmers.co.kr/learn/courses/30/lessons/42889
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Map<Integer, Float> failRateMap = new HashMap<Integer, Float>();
        //Stream<Integer> stagesList = Arrays.stream(stages).boxed();
        float chalCnt = 0; //도전한 사용자 수
        float failCnt = 0; //통과못한 사용자 수

        for (int i = 1; i <= N; i++) { //전체 스테이지 for문
            final int current = i;
            chalCnt = Arrays.stream(stages).filter(o -> o >= current).count(); //도전한 사용자 수
            failCnt = Arrays.stream(stages).filter(o -> o == current).count(); //통과못한 사용자 수
            failRateMap.put(i, chalCnt == 0 ? 0 : (failCnt / chalCnt)); //도전한 사용자가 없으면 실패율 0
        }

        answer = failRateMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Float>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())).mapToInt(o -> o.getKey()).toArray();

        return answer;
    }
}

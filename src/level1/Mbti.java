package level1;

import java.util.HashMap;
import java.util.Map;

public class Mbti {

    //성격유형 검사하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/118666
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> mbtiCal = new HashMap<String, Integer>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};
        String[] mbtiArr = {"RT", "CF", "JM", "AN"};

        for (int i = 0; i < survey.length; i++) { //유형별 점수 계산
            String[] splitSurvey = survey[i].split("");
            if (4 - choices[i] > 0) {
                mbtiCal.put(splitSurvey[0], mbtiCal.get(splitSurvey[0]) + 4 - choices[i]);
            } else {
                mbtiCal.put(splitSurvey[1], mbtiCal.get(splitSurvey[1]) + Math.abs(4 - choices[i]));
            }
        }

        //유형 구하기
        for (String mbti : mbtiArr) {
            String[] splitMbti = mbti.split("");
            if (mbtiCal.get(splitMbti[0]) > mbtiCal.get(splitMbti[1])) {
                answer += splitMbti[0];
            } else if (mbtiCal.get(splitMbti[0]) < mbtiCal.get(splitMbti[1])) {
                answer += splitMbti[1];
            } else {
                answer += (int) splitMbti[0].charAt(0) < (int) splitMbti[1].charAt(0) ? splitMbti[0] : splitMbti[1];
            }
        }
        
        return answer;
    }
}

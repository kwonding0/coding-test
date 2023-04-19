package level1;

import java.util.Arrays;

public class DartGame {

    //다트게임
    //https://school.programmers.co.kr/learn/courses/30/lessons/17682
    public int solution(String dartResult) {
        int answer = 0;
        String[] score = dartResult.split("[SDT][*#]?");
        String[] option = dartResult.replaceAll("10", "1").substring(1).split("\\d");
        double[] cal = new double[3];

        for (int i = 0; i < score.length; i++) {
            cal[i] = option[i].contains("S") ? Math.pow(Double.parseDouble(score[i]), 1)
                    : option[i].contains("D") ? Math.pow(Double.parseDouble(score[i]), 2)
                    : Math.pow(Double.parseDouble(score[i]), 3);

            if (option[i].contains("*")) { //스타상(현재점수, 전점수 2배)
                cal[i] *= 2;
                if (i > 0) cal[i - 1] *= 2;
            } else if (option[i].contains("#")) { //아차상(현재점수 마이너스)
                cal[i] = cal[i] * (-1);
            }
        }

        answer = Arrays.stream(cal).mapToInt(i -> (int) i).sum();
        return answer;
    }
}

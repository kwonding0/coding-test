package level1;

public class AddMinusPlus {

    //음양더하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/76501
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
        }

        return answer;
    }
}

package level0;

import java.util.Arrays;
import java.util.List;


public class PushString {

    //문자열밀기
    //https://school.programmers.co.kr/learn/courses/30/lessons/120921
    public int solution(String A, String B) {
        int answer = -1;

        if(A.equals(B)){
            answer++;
        }else {
            for(int i = 0; i < A.length(); i++){
                A = (A.substring(A.length()-1,A.length()) + A.substring(0,A.length()-1));

                if(A.equals(B)){
                    answer = i+1;
                    break;
                }
            }
        }

        return answer;

        /* 프로그래머스 다른풀이 좋은 예
        B = B.repeat(3);
        return B.indexOf(A);
        */
    }
}

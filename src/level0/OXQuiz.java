package level0;

import java.util.Arrays;

public class OXQuiz {

    //OX퀴즈
    //https://school.programmers.co.kr/learn/courses/30/lessons/120907
    public String[] solution(String[] quiz) {
        String[] answer = {};

        answer = Arrays.stream(quiz).map(o -> {
            String o2 = "";
            o2 = o.replaceAll("( \\+ | = | \\- )",","); //연산기호 삭제
            int[] temp = Arrays.stream(o2.split(",")).mapToInt(i -> Integer.parseInt(i)).toArray(); //숫자별로 배열에 넣기

            if(o.contains("+")){ //덧셈
                return temp[0] + temp[1] == temp[2] ? "O" : "X";
            }else{ //뺄셈
                return temp[0] - temp[1] == temp[2] ? "O" : "X";
            }
        }).toArray(String[]::new);

        return answer;
    }
}

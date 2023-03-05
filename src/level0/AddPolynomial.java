package level0;

import java.util.Arrays;

public class AddPolynomial {

    //다항식 더하기
    //https://school.programmers.co.kr/learn/courses/30/lessons/120863
    public String solution(String polynomial) {
        String answer = "";
        String[] split = polynomial.split(" \\+ ");

        //System.out.println("split = " + Arrays.toString(split));
        //x개수 합산
        int xnum = Arrays.stream(split).filter(o -> o.contains("x"))
                .mapToInt(i -> i.equals("x") ? 1 : Integer.parseInt(i.replace("x","")))
                .sum();

        //System.out.println("xnum = " + xnum);
        //숫자 합산
        int num = Arrays.stream(split).filter(o -> !o.contains("x"))
                .mapToInt(i -> Integer.parseInt(i))
                .sum();
        //System.out.println("num = " + num);

        answer = xnum == 0 ? "" : xnum == 1 ? "x" : xnum + "x";
        answer = num == 0 ? answer : answer.equals("") ? Integer.toString(num) : answer + " + " + num;

        return answer;
    }
}

package level1;

public class TernaryFlip {

    //3진법 뒤집기
    //https://school.programmers.co.kr/learn/courses/30/lessons/68935
    public int solution(int n) {
        int answer = 0;
        String ternary = Integer.toString(n, 3);

        // 문자열 reverse
        StringBuffer sb = new StringBuffer(ternary);
        answer = Integer.parseInt(sb.reverse().toString(), 3);

        return answer;
    }
}

package level2;

public class NBinaryGame {

    //[3차] n진수 게임
    //https://school.programmers.co.kr/learn/courses/30/lessons/17687
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String binary = "";
        int num = -1;
        int order = 0;
        StringBuilder sb = new StringBuilder();

        while (answer.length() < t) {
            order++;
            if (sb.length() == 0) { //다음숫자 n진법으로 구하기
                num++;
                binary = Integer.toString(num, n);
                sb = new StringBuilder(binary);
            }

            if (m == p) {
                if (order % m == 0) {
                    answer.append(sb.substring(0, 1));
                }
            } else {
                if (order % m == p) {
                    answer.append(sb.substring(0, 1));
                }
            }

            sb.deleteCharAt(0);
        }

        return answer.toString().toUpperCase();
    }
}

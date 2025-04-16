package level2;

import javafx.util.Pair;

public class ParenthesesConversion2 {
    //괄호변환
    //https://school.programmers.co.kr/learn/courses/30/lessons/60058

    String correctS = "";

    public String solution(String p) {
        /**
         * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
         * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
         * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
         * 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
         * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
         * 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
         * 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
         * 4-3. ')'를 다시 붙입니다.
         * 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
         * 4-5. 생성된 문자열을 반환합니다.
         */

        return correctU(p);
    }

    /**
     * u를 올바른 괄호 문자열이 나올떄까지 구하기
     */
    public String correctU(String s) {
        int left = 0;
        int right = 0;
        Boolean correct = false;

        // 1
        if (s.isEmpty())
            return s;

        // 2
        Pair<String, String> uAndV = separateUandV(s);
        var u = uAndV.getKey();
        var v = uAndV.getValue();

        // 3
        if (isCorrectString(u))
            return u + correctU(v);
        else {
            return makeCorrectString(u, v);
        }

        /*for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            u += c;

            //왼쪽오른쪽 괄호 카운팅
            if (c == '(') {
                left++;
                if (i == 0) correct = true; //올바른괄호인지 확인 (맨 앞이 왼쪽이면 올바른 괄호)
            } else {
                right++;
            }

            //개수 같으면 균형잡힌 괄호 문자열이므로 u로 설정
            if (left == right) {
                v = s.substring(i + 1); //s에서 u를 제외한 나머지는 v
                if (correct) { //올바른 괄호일때
                    correctS += u; //정답에 u더함
                    if (v.length() > 0) {
                        return correctU(v); //나머지 괄호로 함수 다시 호출
                    } else {
                        return correctS; //나머지 괄호가 없을 때 재귀 종료
                    }
                }
                break;
            }
        }

        //올바른괄호가 아니면 4단계 진행
        correctS += "(";
        if (v.length() > 0) correctU(v); //v로 1~3단계 진행한값 정답에 더해줌
        correctS += ")";
        u = u.length() == 2 ? "" : u.substring(1, u.length() - 1); //u의 앞뒤문자 제거
        u = u.replaceAll("\\(", ")a").replaceAll("\\)(?!a)", "(").replaceAll("a", ""); //괄호 모두 반대로 바꿈
        correctS += u;
        return correctS;*/
    }

    private String makeCorrectString(String u, String v) {
        return u;
    }

    private boolean isCorrectString(String u) {
        return true;
    }

    private Pair<String, String> separateUandV(String s) {

        return new Pair("", "");
    }
}

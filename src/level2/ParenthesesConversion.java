package level2;

public class ParenthesesConversion {
    String v = "";
    //괄호변환
    //https://school.programmers.co.kr/learn/courses/30/lessons/60058

    /**
     * u를 올바른 괄호 문자열이 나올떄까지 구하기
     */
    public String correctU(String s) {
        System.out.println("s = " + s);
        int left = 0;
        int right = 0;
        String u = "";
        Boolean correct = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("c = " + c);
            if (c == '(') {
                left++;
                if (i == 0) correct = true; //올바른괄호인지 확인 (맨 앞이 왼쪽이면 올바른 괄호)
            } else {
                right++;
            }
            u += c;
            if (left == right) {
                if (correct) {
                    v += u;
                    s = s.substring(i);
                    break;
                }
            }
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("u = " + u);

        //올바른괄호가 아니면 4단계 진행



        return correctU(s);

        /*s
        for(){

        }
        if(n == 0)
            return 0;

        if(n == 1 || n == 2)
            return 1;

        else
            return rightU();*/
    }

    public String solution(String p) {
        String answer = "";

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

        answer = correctU(p);
        System.out.println("answer = " + answer);
        System.out.println("v = " + v);
        return answer;
    }
}
